package org.example.orika.model;

import lombok.Data;

@Data
public class RequestDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String localStreet;
    private Long localPinCode;
    private String localCountry;
    private String localState;

    private String billingStreet;
    private Long billingPinCode;
    private String billingCountry;
    private String billingState;

    private String fatherFirstName;
    private String fatherLastName;
    private Integer fatherAge;

    private String motherFirstName;
    private String motherLastName;
    private Integer motherAge;

    private String gearType;
    private String bodyType;
    private String fuelType;
    private String wheelPlacement;
    private String rimType;
    private String tyreType;
    private String color;
    private String upholestryType;

    private String price;
    private String model;

}
