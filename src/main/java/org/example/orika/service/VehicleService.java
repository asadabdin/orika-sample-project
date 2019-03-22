package org.example.orika.service;

import lombok.RequiredArgsConstructor;
import org.example.orika.properties.VehicleMappingProperties;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleMappingProperties vehicleMappingProperties;

    public Integer getGearType(String gearType) {
        return vehicleMappingProperties.getGearTypes().get(gearType);
    }

    public String getGearType(Integer gearType) {
        return vehicleMappingProperties.getGearTypes().inverse().get(gearType);
    }

    public Integer getBodyType(String bodyType) {
        return vehicleMappingProperties.getBodyTypes().get(bodyType);
    }

    public String getBodyType(Integer bodyType) {
        return vehicleMappingProperties.getBodyTypes().inverse().get(bodyType);
    }

    public Integer getColor(String color) {
        return vehicleMappingProperties.getColors().get(color);
    }

    public String getColor(Integer color) {
        return vehicleMappingProperties.getColors().inverse().get(color);
    }

    public Integer getFuelType(String bodyType) {
        return vehicleMappingProperties.getFuelTypes().get(bodyType);
    }

    public String getFuelType(Integer bodyType) {
        return vehicleMappingProperties.getFuelTypes().inverse().get(bodyType);
    }

    public Integer getRimType(String bodyType) {
        return vehicleMappingProperties.getRimTypes().get(bodyType);
    }

    public String getRimType(Integer bodyType) {
        return vehicleMappingProperties.getRimTypes().inverse().get(bodyType);
    }

    public Integer getTyreType(String bodyType) {
        return vehicleMappingProperties.getTyreTypes().get(bodyType);
    }

    public String getTyreType(Integer bodyType) {
        return vehicleMappingProperties.getTyreTypes().inverse().get(bodyType);
    }

    public String getWheelPlacement(String bodyType) {
        return vehicleMappingProperties.getWheelPlacement().get(bodyType);
    }

    public String getWheelPlacementInverse(String bodyType) {
        return vehicleMappingProperties.getWheelPlacement().inverse().get(bodyType);
    }

    public Integer getUpholestryTypes(String bodyType) {
        return vehicleMappingProperties.getUpholestryTypes().get(bodyType);
    }

    public String getUpholestryTypes(Integer bodyType) {
        return vehicleMappingProperties.getUpholestryTypes().inverse().get(bodyType);
    }

}
