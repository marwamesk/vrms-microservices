package com.champsoft.vrms.cars.domain.model;

import com.champsoft.vrms.cars.domain.exception.InvalidVinException;

import java.util.Objects;

public final class Vin{

    private final String value;

    public Vin(String value){

        if(value==null) throw new InvalidVinException("Vin is required");
        String v = value.trim().toUpperCase();
        if(v.length()<11 || v.length()>17 ){
            throw new InvalidVinException("Vin length must be 11..17");
        }
        this.value=v;
    }

    public String value(){
        return value;
    }

    @Override public boolean equals(Object o){
        return (o instanceof Vin other) && Objects.equals(value,other.value);
    }

    @Override public int hashCode(){
        return Objects.hash(value);
    }

    @Override public String toString(){
        return value;
    }



}
