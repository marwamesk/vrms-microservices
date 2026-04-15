package com.champsoft.vrms.agents.api.dto;

import com.champsoft.vrms.agents.domain.model.Role;

public record UpdateAgentRequest(
        String name,
        Role role
) {
}
