package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Optional;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseDto {

    private Optional<Long> id ;
    private Optional<String> firstName ;
    private Optional<String> lastName ;
    private Optional<Integer> age ;

    private Address localAddress;
    private Address billingAddress;

    private PersonDetails fatherInfo;
    private PersonDetails motherInfo;

    private VehicleDto vehicleDto;

}
