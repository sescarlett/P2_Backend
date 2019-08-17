package com.bananas.services;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.bananas.entities.Movie;
import com.bananas.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	EntityManager entityManager;
	
	MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}
	
	// creates a new movie object
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	// gets a movie by id otherwise throws an exception
	@Transactional(propagation = Propagation.NEVER)
	public Movie getById(int id) {
		return movieRepository.findById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	

}
