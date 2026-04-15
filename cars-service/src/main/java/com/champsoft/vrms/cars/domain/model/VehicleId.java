package com.champsoft.vrms.cars.domain.model;
import java.util.Objects;
import java.util.UUID;

public final class VehicleId {

    private final String value;

        public VehicleId(String value){
            this.value=value;
        }

        //generating a new id
        public static VehicleId newId(){
            return new VehicleId(UUID.randomUUID().toString());
        }

        //Creating an id from existing value
        public static VehicleId of(String value){
            return new VehicleId(value);
        }

        public String value(){
            return value;
        }

        @Override
        public boolean equals(Object o){
            return (o instanceof VehicleId other)&& Objects.equals(value,other.value);
        }

        @Override
        public int hashCode(){
            return Objects.hash(value);
        }

        @Override
        public String toString(){
            return value;
        }
}
