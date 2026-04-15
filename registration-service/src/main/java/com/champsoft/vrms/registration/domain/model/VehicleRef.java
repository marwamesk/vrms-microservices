package com.champsoft.vrms.registration.domain.model;

public record VehicleRef(String vehicleId) {
    public VehicleRef{
        if(vehicleId == null) throw new IllegalArgumentException("vehicleId is required");
        vehicleId.trim();
        if(vehicleId.isEmpty()) throw new IllegalArgumentException("vehicleId is required");
    }
}
