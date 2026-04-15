package com.champsoft.vrms.agents.infrastructure.persistence;

import com.champsoft.vrms.agents.application.port.out.AgentRepositoryPort;

import com.champsoft.vrms.agents.domain.model.Agent;
import com.champsoft.vrms.agents.domain.model.AgentId;
import com.champsoft.vrms.agents.domain.model.Role;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;


@Component
public class JpaAgentRepositoryAdapter implements AgentRepositoryPort {

    private final SpringDataAgentRepository jpa;

    public JpaAgentRepositoryAdapter(SpringDataAgentRepository jpa){
        this.jpa=jpa;
    }

    @Override
    public Agent save(Agent agent) {
       jpa.save(toEntity(agent));
       return agent;
    }

    @Override
    public Optional<Agent> findById(AgentId id) {
        return jpa.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Agent> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(AgentId id) {
        jpa.deleteById(id.value());

    }

    @Override
    public boolean existByName(String name) {
        return jpa.existsByName(name);
    }


    private AgentJpaEntity toEntity(Agent e){
        var a = new AgentJpaEntity();
        a.id=e.id().value();
        a.name=e.name();
        a.role=e.role();
        a.status= e.status().name();
        return a;
    }

    private Agent toDomain(AgentJpaEntity a){
        var e = new Agent(AgentId.of(a.id),a.name,Role.valueOf(String.valueOf(a.role)));
        if("ACTIVE".equalsIgnoreCase(a.status)) e.activate();
        return e;
    }
}
