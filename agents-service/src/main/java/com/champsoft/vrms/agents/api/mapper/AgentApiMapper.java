package com.champsoft.vrms.agents.api.mapper;

import com.champsoft.vrms.agents.api.dto.AgentResponse;
import com.champsoft.vrms.agents.domain.model.Agent;

public class AgentApiMapper {

    public static AgentResponse toResponse(Agent agent) {
        return new AgentResponse(
                agent.id().value(),
                agent.name(),
                agent.role().name(),
                agent.status().name()
        );
    }
}
