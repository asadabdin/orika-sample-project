package com.example.test.config;


import com.example.test.properties.OrikaProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.Converter;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(OrikaProperties.class)
@ConditionalOnProperty(name = "orika.enabled", matchIfMissing = true)
public class OrikaConfiguration {

    /**
     * The configuration properties for Orika.
     */
    private final OrikaProperties orikaProperties;

    /**
     * Every Possible mapping defined
     */
    private final Optional<List<ObjectMapping>> objectMappings;

    /**
     * Every Possible Custom Mapper Defined
     */
   // private final Optional<List<CustomMapper>> customMappers;

    /**
     * Every possible Object Converter if it is not available built in
     */
    private final Optional<List<Converter>> converters;

    private static final Type<ObjectMapping> OBJECT_MAPPING_INTERFACE = TypeFactory.valueOf(ObjectMapping.class);

    /**
     * Creates a {@link MapperFactoryBuilder}.
     *
     * @return a {@link MapperFactoryBuilder}.
     */
    @Bean
    @ConditionalOnMissingBean
    public MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder() {
        DefaultMapperFactory.Builder orikaMapperFactoryBuilder = new DefaultMapperFactory.Builder();
        Optional.ofNullable(orikaProperties.getUseBuiltinConverters())
                .ifPresent(useBuiltinConverters ->  orikaMapperFactoryBuilder.useBuiltinConverters(useBuiltinConverters));
        Optional.ofNullable(orikaProperties.getUseAutoMapping())
                .ifPresent(useAutoMapping -> orikaMapperFactoryBuilder.useAutoMapping(useAutoMapping));
        Optional.ofNullable(orikaProperties.getMapNulls())
                .ifPresent(mapNulls -> orikaMapperFactoryBuilder.mapNulls(mapNulls));
        Optional.ofNullable(orikaProperties.getDumpStateOnException())
                .ifPresent(dumpStateOnException -> orikaMapperFactoryBuilder.dumpStateOnException(dumpStateOnException));
        Optional.ofNullable(orikaProperties.getFavorExtension())
                .ifPresent(favorExtension -> orikaMapperFactoryBuilder.favorExtension(favorExtension));
        Optional.ofNullable(orikaProperties.getCaptureFieldContext())
                .ifPresent(captureFieldContext -> orikaMapperFactoryBuilder.captureFieldContext(captureFieldContext));
        log.debug("Created a MapperFactoryBuilder: [{}]", orikaMapperFactoryBuilder);
        return orikaMapperFactoryBuilder;
    }

    /**
     * Creates a {@link MapperFactory}.
     *
     * @param orikaMapperFactoryBuilder the {@link MapperFactoryBuilder}.
     * @return a {@link MapperFactory}.
     */
    @Bean
    @ConditionalOnMissingBean
    public MapperFactory orikaMapperFactory(MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder) {
        MapperFactory orikaMapperFactory = orikaMapperFactoryBuilder.build();

        //Registering Object Mappings
        objectMappings
                .orElseGet(Collections::emptyList)
                .forEach(objectMapping ->  {
                    ClassMapBuilder classMapBuilder = getClassMapBuilder(orikaMapperFactory, objectMapping);
                    objectMapping.classMap(classMapBuilder);
                    orikaMapperFactory.registerClassMap(classMapBuilder);
                });

        //Registering Object Custom Mapper
/*
        customMappers
                .orElseGet(Collections::emptyList)
                .forEach(customMapper -> orikaMapperFactory.registerMapper(customMapper));
*/

        //Registering Custom Object Converter if not supported out of the Box
        converters
                .orElseGet(Collections::emptyList)
                .forEach(converter -> orikaMapperFactory.getConverterFactory().registerConverter(converter));


        log.debug("Created a MapperFactory: [{}]", orikaMapperFactory);
        return orikaMapperFactory;
    }

    /**
     * Creates a {@link MapperFacade}.
     *
     * @param orikaMapperFactory the {@link MapperFactory}.
     * @return a {@link MapperFacade}.
     */
    @Bean
    @ConditionalOnMissingBean
    public MapperFacade orikaMapperFacade(MapperFactory orikaMapperFactory) {
        MapperFacade orikaMapperFacade = orikaMapperFactory.getMapperFacade();
        log.debug("Created a MapperFacade: [{}]", orikaMapperFacade);
        return orikaMapperFacade;
    }

    /**
     * Extract the GenericType from the Implementation of {@link ObjectMapping}
     * @param orikaMapperFactory
     * @param objectMapping
     * @return object of {@link ClassMapBuilder}
     */
    private ClassMapBuilder getClassMapBuilder(MapperFactory orikaMapperFactory, ObjectMapping objectMapping) {
        Type<?> objectMappingInterface = TypeFactory.valueOf(objectMapping.getClass()).findInterface(OBJECT_MAPPING_INTERFACE);
        return orikaMapperFactory
                .classMap(TypeFactory.valueOf(objectMappingInterface.getActualTypeArguments()[0]),
                        TypeFactory.valueOf(objectMappingInterface.getActualTypeArguments()[1]));
    }
}
