package com.champsoft.vrms.cars.api.mapper;


import com.champsoft.vrms.cars.api.dto.VehicleResponse;
import com.champsoft.vrms.cars.domain.model.Vehicle;

public class VehicleApiMapper {

    public static VehicleResponse toResponse(Vehicle v){
        return new VehicleResponse(
                v.id().value(),
                v.vin().value(),
                v.vehicleSpecs().make(),
                v.vehicleSpecs().model(),
                v.vehicleSpecs().year(),
                v.status().name()
        );
    }
}
