package com.dickens.esportsscoreboard.Components;

import com.dickens.esportsscoreboard.Models.MatchModel;
import com.dickens.esportsscoreboard.Service.MatchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Component
public class MatchLoader implements CommandLineRunner {
    public final MatchRepository matchRepository;

    public MatchLoader(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadMatches();
    }

    private void loadMatches() {
        if (matchRepository.count() == 0) {

            var match =    MatchModel.builder()
                    .id(UUID.randomUUID().toString())
                    .gameName("MK 11")
                    .playerOneName("Tapiwa")
                    .playerTwoName("Tatenda")
                    .scoreLeft(2)
                    .scoreRight(1)
                    .build();

            matchRepository.save(match);

            match =  MatchModel.builder()
                    .id(UUID.randomUUID().toString())
                    .gameName("MK 11")
                    .playerOneName("Tawanda")
                    .playerTwoName("Tatenda")
                    .scoreLeft(2)
                    .scoreRight(1)
                    .build();

            matchRepository.save(match);
            System.out.println("Sample Matches Loaded");
        }
    }
}