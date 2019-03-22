package org.example.orika.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;
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
    private List<PersonDetails> personDetails;

    private Map<String, String> nameMap;

    private VehicleDto vehicleDto;

}
