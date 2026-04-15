package com.champsoft.vrms.agents.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record AgentResponse(
        @NotEmpty String id, @NotBlank String name,@NotEmpty String role,@NotEmpty String status
) {

}
