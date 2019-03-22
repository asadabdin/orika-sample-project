package org.example.orika.mapping;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.example.orika.config.ObjectMapping;
import org.example.orika.mapping.custom.VehicleDtoAndRequestDtoCustomMapper;
import org.example.orika.model.RequestDto;
import org.example.orika.model.ResponseDto;
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
                //Nested Object
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

                //List
                .field("fatherFirstName", "personDetails[0].firstName")
                .field("fatherLastName", "personDetails[0].lastName")
                .field("fatherAge", "personDetails[0].age")

                .field("motherFirstName", "personDetails[1].firstName")
                .field("motherLastName", "personDetails[1].lastName")
                .field("motherAge", "personDetails[1].age")

                //Map
                .field("fatherFirstName", "nameMap['firstName']")
                .field("fatherLastName", "nameMap['lastName']")

        ;
    }
}
