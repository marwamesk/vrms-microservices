package com.champsoft.vrms.agents.application.service;


import com.champsoft.vrms2432911.modules.agents.application.exception.AgentNotFoundException;
import com.champsoft.vrms2432911.modules.agents.application.exception.DuplicateAgentException;
import com.champsoft.vrms.agents.application.port.out.AgentRepositoryPort;
import com.champsoft.vrms.agents.domain.model.Agent;
import com.champsoft.vrms.agents.domain.model.AgentId;
import com.champsoft.vrms.agents.domain.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgentCrudService {

    private final AgentRepositoryPort repo;

    public AgentCrudService(AgentRepositoryPort repo) {
        this.repo = repo;
    }

    @Transactional
    public Agent create(String name, Role role) {
        var a = new Agent(AgentId.newId(), name, role);
        if (repo.existByName(a.name())) {
            throw new DuplicateAgentException("Agent already exist by Name: " + a.name());
        }
        return repo.save(a);
    }

    //why string and not AgentId
    @Transactional(readOnly = true)
    public Agent getById(String id){
        return repo.findById(AgentId.of(id)).orElseThrow(() -> new AgentNotFoundException("Agent not found: "+ id));
    }

    @Transactional(readOnly = true)
    public List<Agent> list(){
        return repo.findAll();
    }

    @Transactional
    public Agent update(String id, String name, Role role){
        var agent = getById(id);
        agent.update(name,role);
        return repo.save(agent);
    }

    @Transactional
    public Agent activate(String id){
        var a = getById(id);
        a.activate();
        return repo.save(a);
    }

    @Transactional
    public void delete(String id){
        getById(id);
        repo.deleteById(AgentId.of(id));

    }
}

