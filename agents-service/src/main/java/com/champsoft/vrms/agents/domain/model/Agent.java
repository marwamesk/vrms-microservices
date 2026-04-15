package com.champsoft.vrms.agents.domain.model;

import com.champsoft.vrms2432911.modules.agents.domain.exception.InvalidAgentName;
import com.champsoft.vrms2432911.modules.agents.domain.exception.InvalidRoleException;


public class Agent {

    private final AgentId id;
    private AgentStatus status;
    private Role role;
    private String name;

    public Agent(AgentId id,String name, Role role){
        this.id=id;
        this.name=name;
        this.role=role;
        this.status=AgentStatus.INACTIVE;
    }

    public AgentId id(){return id;}
    public AgentStatus status(){return status;}
    public Role role(){return role;}
    public String name(){return name;}

    public void activate(){
        this.status = AgentStatus.ACTIVE;
    }

    public boolean AgentEligible(){
        return this.status == AgentStatus.ACTIVE;
    }

    public void setName(String name){
        if(name == null) throw new InvalidAgentName("Agent name is required");
        String v = name.trim();
        if(v.length()<2 || v.length()>120) throw new InvalidAgentName("Agent name length must be between 2...120");
        this.name=v;
    }

    private void setRole(Role role){
        if(role == null) throw new InvalidRoleException("Agent must have a role");
        this.role=role;
    }
    public void update(String name,Role role){
        setName(name);
        setRole(role);
    }

}