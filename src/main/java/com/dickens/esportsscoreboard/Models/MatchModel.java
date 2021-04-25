package com.dickens.esportsscoreboard.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchModel extends ServiceObject{

    private int scoreLeft;
    private int scoreRight;
    private String playerOneName;
    private String playerTwoName;
    private String gameName;

}
