package com.devsuperior.dsmovie.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.ScorePk;

public interface ScoreRepository extends JpaRepository<Score, ScorePk>{

}
