package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositores.MovieRepository;
import com.devsuperior.dsmovie.repositores.ScoreRepository;
import com.devsuperior.dsmovie.repositores.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ScoreRepository scoreRepository;
	
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.steMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		double sum = 0.0;
		for (Score s :movie.getScores()){
			sum = sum + s.getValue();
		}
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		return new MovieDTO(movie);
	}
}
