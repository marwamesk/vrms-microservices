package com.champsoft.vrms.agents.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataAgentRepository extends JpaRepository<AgentJpaEntity,String> {

    Optional<AgentJpaEntity> findById(String id);
    boolean existsByName(String name);

}
