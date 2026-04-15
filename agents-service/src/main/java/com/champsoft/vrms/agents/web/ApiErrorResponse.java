package com.champsoft.vrms.agents.web;

import java.time.Instant;

public record ApiErrorResponse(
//        String message, String code
        Instant timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
