package com.champsoft.vrms.registration.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CancelRegistrationRequest(
        @NotBlank String registrationId) {

    public String registrationId(){
        return registrationId;
    }
}
