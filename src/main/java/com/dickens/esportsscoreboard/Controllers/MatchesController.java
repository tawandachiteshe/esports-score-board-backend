package com.dickens.esportsscoreboard.Controllers;

import com.dickens.esportsscoreboard.Models.MatchModel;
import com.dickens.esportsscoreboard.Service.MatchService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/matches")
public class MatchesController {


    MatchService matchService;

    public MatchesController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public ResponseEntity<List<MatchModel>> getAllMatches() {
        List<MatchModel> matches = matchService.getMatches();
        System.out.println(matches + "TAWDNA");
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }


    @GetMapping({"/{matchID}"})
    public ResponseEntity<MatchModel> getMatch(@PathVariable String matchId) {
        return new ResponseEntity<>(matchService.getMatchById(matchId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatchModel> saveMatch(@RequestBody MatchModel matchModel) {
        MatchModel match = matchService.create(matchModel);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("todo", "/api/v1/todo/" + match.getId().toString());
        return new ResponseEntity<>(match, httpHeaders, HttpStatus.CREATED);
    }


    @PutMapping({"/{matchId}"})
    public ResponseEntity<MatchModel> updateMatch(@PathVariable("matchId") String matchId, @RequestBody MatchModel match) {
        matchService.updateMatch(matchId, match);
        return new ResponseEntity<>(matchService.getMatchById(matchId), HttpStatus.OK);
    }


    @DeleteMapping({"/{matchId}"})
    public ResponseEntity<MatchModel> deleteMatch(@PathVariable("matchId") String matchId) {
        matchService.deleteMatch(matchId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
