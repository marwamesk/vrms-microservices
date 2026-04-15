package com.champsoft.vrms.agents.domain.model;


import java.time.DayOfWeek;
import java.util.UUID;

public final class AgentId {

    private final String value;
    private DayOfWeek day;

    private AgentId(String value){
        this.value=value;
    }

    public static AgentId newId(){
        return new AgentId(UUID.randomUUID().toString());
    }

    public static AgentId of(String value){
        return new AgentId(value);
    }

    public String value(){
        return value;
    }


}
