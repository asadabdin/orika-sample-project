package com.example.test.mapping;

import com.example.test.config.ObjectMapping;
import com.example.test.mapping.custom.VehicleDtoAndRequestDtoCustomMapper;
import com.example.test.model.RequestDto;
import com.example.test.model.ResponseDto;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestDtoAndResponseDtoMapping implements ObjectMapping<RequestDto, ResponseDto> {

    private final VehicleDtoAndRequestDtoCustomMapper vehicleDtoAndRequestDtoCustomMapper;

    @Override
    public void classMap(ClassMapBuilder<RequestDto, ResponseDto> classMapBuilder) {
        classMapBuilder
                .byDefault()
                .customize(vehicleDtoAndRequestDtoCustomMapper)
                .field("localStreet", "localAddress.street")
                .field("localPinCode", "localAddress.pinCode")
                .field("localCountry", "localAddress.country")
                .field("localState", "localAddress.state")

                .field("billingStreet", "billingAddress.street")
                .field("billingPinCode", "billingAddress.pinCode")
                .field("billingCountry", "billingAddress.country")
                .field("billingState", "billingAddress.state")

                .field("fatherFirstName", "fatherInfo.firstName")
                .field("fatherLastName", "fatherInfo.lastName")
                .field("fatherAge", "fatherInfo.age")

                .field("motherFirstName", "motherInfo.firstName")
                .field("motherLastName", "motherInfo.lastName")
                .field("motherAge", "motherInfo.age")
                .field("price", "vehicleDto.price")
                .field("model", "vehicleDto.model")
        ;
    }
}
