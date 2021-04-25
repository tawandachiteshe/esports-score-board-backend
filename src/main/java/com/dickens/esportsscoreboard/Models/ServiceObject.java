package com.dickens.esportsscoreboard.Models;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ServiceObject {
    @Id
    @Type(type = "pg-uuid")
    private UUID id;

    public ServiceObject() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}