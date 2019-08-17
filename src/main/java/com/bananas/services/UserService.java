package com.bananas.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.bananas.entities.User;
import com.bananas.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	EntityManager entityManager;

	UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	//creates a new user
	public User createUser(User user) {
		return userRepository.save(user);
	}

	// gets all users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// gets a user by id otherwise throws an exception
	@Transactional(propagation = Propagation.NEVER)
	public User getById(int id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	// updates a user
	// technically not needed - could use create User
	public User updateUser(User update) {
		return userRepository.save(update);
	}

}
