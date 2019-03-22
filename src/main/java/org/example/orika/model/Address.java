package org.example.orika.model;

import lombok.Data;

@Data
public class Address {

    private String street;
    private Long pinCode;
    private String country;
    private String state;

}
