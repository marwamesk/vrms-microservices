package com.champsoft.vrms.cars.api.dto;



public record VehicleResponse(
        String id,
        String vin,
        String model,
        String make,
        int year,
        String status) {
}
