package com.dickens.esportsscoreboard.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;



class ServiceObject {
    @Id
    @Type(type = "pg-uuid")
    private UUID id;

    public ServiceObject() {
        this.id = UUID.randomUUID();
    }
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchModel extends ServiceObject{

    private int scoreLeft;
    private int scoreRight;
    private String id;
    private String playerOneName;
    private String playerTwoName;
    private String gameName;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
