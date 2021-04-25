package com.dickens.esportsscoreboard.Service;

import com.dickens.esportsscoreboard.Models.MatchModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MatchRepository extends CrudRepository<MatchModel, UUID> { }
