package com.bananas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bananas.entities.Movie;
import com.bananas.services.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	/**
	 * creates a new movie
	 * @param movie object to add
	 * @return the newly created movie object
	 */
	@PostMapping("")
	public Movie createMovie(@RequestBody Movie movie) {
		return movieService.createMovie(movie);
	}
}
