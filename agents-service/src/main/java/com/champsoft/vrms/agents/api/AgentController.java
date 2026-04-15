package com.champsoft.vrms.agents.api;

import com.champsoft.vrms.agents.api.dto.CreateAgentRequest;
import com.champsoft.vrms.agents.api.dto.UpdateAgentRequest;
import com.champsoft.vrms.agents.api.mapper.AgentApiMapper;
import com.champsoft.vrms.agents.application.service.AgentCrudService;
import com.champsoft.vrms.agents.application.service.AgentEligibilityService;
import jakarta.validation.Valid;
import org.h2.command.dml.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/agents")
public class AgentController {

    private final AgentCrudService service;
    private final AgentEligibilityService eligibilityService;

    public AgentController(AgentCrudService service, AgentEligibilityService eligibilityService){
        this.service=service;
        this.eligibilityService = eligibilityService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateAgentRequest req){
        var v = service.create(req.name(),req.role());
        return ResponseEntity.ok(AgentApiMapper.toResponse(v));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id){
        return ResponseEntity.ok(AgentApiMapper.toResponse(service.getById(id)));
    }

    @GetMapping
    public ResponseEntity <?> List(){
        List<?> data = service.list().stream().map(AgentApiMapper::toResponse).toList();
        return ResponseEntity.ok(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, UpdateAgentRequest req){
        var v = service.update(id, req.name(), req.role());
        return ResponseEntity.ok(AgentApiMapper.toResponse(v));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> activate(@PathVariable String id){
        var v = service.activate(id);
        return ResponseEntity.ok(AgentApiMapper.toResponse(v));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{id}/eligibility")
    public ResponseEntity<Boolean> isEligible(@PathVariable String id){
        return ResponseEntity.ok(eligibilityService.isEligible(id));
    }
}
