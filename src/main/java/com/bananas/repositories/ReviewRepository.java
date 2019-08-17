package com.bananas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bananas.entities.Movie;
import com.bananas.entities.Review;
import com.bananas.entities.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	// finds all reviews given a user object
	List<Review> findAllByUser(User user);

	// finds all reviews given a movie object
	List<Review> findAllByMovie(Movie movie);

}
