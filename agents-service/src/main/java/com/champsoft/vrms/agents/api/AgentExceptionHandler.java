package com.champsoft.vrms.agents.api;

import com.champsoft.vrms.agents.web.ApiErrorResponse;
import com.champsoft.vrms2432911.modules.agents.application.exception.AgentNotFoundException;
import com.champsoft.vrms2432911.modules.agents.application.exception.DuplicateAgentException;
import com.champsoft.vrms2432911.modules.agents.domain.exception.AgentNotEligibleException;
import com.champsoft.vrms2432911.modules.agents.domain.exception.InvalidAgentName;
import com.champsoft.vrms2432911.modules.agents.domain.exception.InvalidRoleException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.*;

import java.time.Instant;

@RestControllerAdvice(assignableTypes= AgentController.class)
public class AgentExceptionHandler {

    @ExceptionHandler(AgentNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFound(AgentNotFoundException ex, HttpServletRequest req){
        return build(HttpStatus.NOT_FOUND,ex,req);
    }

    @ExceptionHandler(DuplicateAgentException.class)
    public ResponseEntity<ApiErrorResponse> conflict(DuplicateAgentException ex, HttpServletRequest req){
        return build(HttpStatus.CONFLICT,ex,req);
    }

    @ExceptionHandler({
            InvalidRoleException.class,
            InvalidAgentName.class,
            AgentNotEligibleException.class
    })
    public ResponseEntity<ApiErrorResponse> badRequest(RuntimeException ex,HttpServletRequest req){
        return build(HttpStatus.BAD_REQUEST,ex,req);
    }


    private ResponseEntity<ApiErrorResponse> build(HttpStatus status,Exception ex,HttpServletRequest req){
        var body = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );
        return ResponseEntity.status(status).body(body);
    }
}
