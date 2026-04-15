package com.champsoft.vrms.owners.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name= "owners")
public class OwnerJpaEntity {
    @Id
    public String id;

    @Column(name = "full_name", nullable = false)
    public String fullName;

    @Column(name = "address")
    public String address;

    @Column(nullable = false)
    public String status;
}
