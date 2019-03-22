package org.example.orika.mapping.custom;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.example.orika.model.RequestDto;
import org.example.orika.model.ResponseDto;
import org.example.orika.model.VehicleDto;
import org.example.orika.service.VehicleService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleDtoAndRequestDtoCustomMapper extends CustomMapper<RequestDto, ResponseDto> {

    private final VehicleService vehicleService;

    @Override
    public void mapAtoB(RequestDto requestDto, ResponseDto responseDto, MappingContext context) {
        VehicleDto vehicleDto = Optional.ofNullable(responseDto.getVehicleDto())
                .orElseGet(() -> new VehicleDto());
        Optional.ofNullable(requestDto.getGearType())
                .ifPresent(gearType -> vehicleDto.setGear(vehicleService.getGearType(gearType)));

        Optional.ofNullable(requestDto.getBodyType())
                .ifPresent(bodyType -> vehicleDto.setBody(vehicleService.getBodyType(bodyType)));

        Optional.ofNullable(requestDto.getFuelType())
                .ifPresent(fuelType -> vehicleDto.setFuel(vehicleService.getFuelType(fuelType)));

        Optional.ofNullable(requestDto.getWheelPlacement())
                .ifPresent(wheelPlacement -> vehicleDto.setWheel(vehicleService.getWheelPlacement(wheelPlacement)));

        Optional.ofNullable(requestDto.getRimType())
                .ifPresent(rimType -> vehicleDto.setRim(vehicleService.getRimType(rimType)));

        Optional.ofNullable(requestDto.getTyreType())
                .ifPresent(tyreType -> vehicleDto.setTyre(vehicleService.getTyreType(tyreType)));

        Optional.ofNullable(requestDto.getColor())
                .ifPresent(color -> vehicleDto.setColor(vehicleService.getColor(color)));

        Optional.ofNullable(requestDto.getUpholestryType())
                .ifPresent(upholestryType -> vehicleDto.setUpholestry(vehicleService.getUpholestryTypes(upholestryType)));
    }

    @Override
    public void mapBtoA(ResponseDto responseDto, RequestDto requestDto, MappingContext context) {
        VehicleDto vehicleDto = responseDto.getVehicleDto();
        Optional.ofNullable(vehicleDto.getGear())
                .ifPresent(gearType -> requestDto.setGearType(vehicleService.getGearType(gearType)));

        Optional.ofNullable(vehicleDto.getBody())
                .ifPresent(bodyType -> requestDto.setBodyType(vehicleService.getBodyType(bodyType)));

        Optional.ofNullable(vehicleDto.getFuel())
                .ifPresent(fuelType -> requestDto.setFuelType(vehicleService.getFuelType(fuelType)));

        Optional.ofNullable(vehicleDto.getWheel())
                .ifPresent(wheelPlacement -> requestDto.setWheelPlacement(vehicleService.getWheelPlacementInverse(wheelPlacement)));

        Optional.ofNullable(vehicleDto.getRim())
                .ifPresent(rimType -> requestDto.setRimType(vehicleService.getRimType(rimType)));

        Optional.ofNullable(vehicleDto.getTyre())
                .ifPresent(tyreType -> requestDto.setTyreType(vehicleService.getTyreType(tyreType)));

        Optional.ofNullable(vehicleDto.getColor())
                .ifPresent(color -> requestDto.setColor(vehicleService.getColor(color)));

        Optional.ofNullable(vehicleDto.getUpholestry())
                .ifPresent(upholestryType -> requestDto.setUpholestryType(vehicleService.getUpholestryTypes(upholestryType)));

    }

}
