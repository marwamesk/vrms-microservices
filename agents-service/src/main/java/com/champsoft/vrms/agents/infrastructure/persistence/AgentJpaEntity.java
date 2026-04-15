package com.champsoft.vrms.agents.infrastructure.persistence;

import com.champsoft.vrms.agents.domain.model.Role;
import jakarta.persistence.*;


@Entity
@Table(name="agents")
public class AgentJpaEntity {
    @Id
    public String id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public Role role;

    @Column(nullable = false)
    public String status;







}
