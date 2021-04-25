package com.dickens.esportsscoreboard.Service;


import com.dickens.esportsscoreboard.Models.MatchModel;

import java.util.List;

public interface MatchService {

    List<MatchModel> getMatches();

    MatchModel getMatchById(String id);

    MatchModel create(MatchModel match);

    void updateMatch(String id, MatchModel match);

    void deleteMatch(String id);


}
