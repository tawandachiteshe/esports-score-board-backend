package com.dickens.esportsscoreboard.Service;

import com.dickens.esportsscoreboard.Models.MatchModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MatchServiceImpl implements MatchService {

    MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<MatchModel> getMatches() {

        List<MatchModel> matches = new ArrayList<>();
        matchRepository.findAll().forEach(matches::add);

        return matches;
    }

    @Override
    public MatchModel getMatchById(String id) {
        return matchRepository.findById(UUID.fromString(id)).get();
    }

    @Override
    public MatchModel create(MatchModel match) {
        return matchRepository.save(match);
    }

    @Override
    public void updateMatch(String id, MatchModel match) {

        MatchModel matchFromDb = matchRepository.findById(UUID.fromString(id)).get();
        System.out.println(matchFromDb.toString());
        matchFromDb.setGameName(match.getGameName());
        matchFromDb.setScoreLeft(match.getScoreLeft());
        matchFromDb.setScoreRight(match.getScoreRight());
        matchFromDb.setPlayerOneName(match.getPlayerOneName());
        matchFromDb.setPlayerTwoName(match.getPlayerTwoName());
        matchRepository.save(matchFromDb);

    }

    @Override
    public void deleteMatch(String id) {

        matchRepository.deleteById(UUID.fromString(id));

    }
}
