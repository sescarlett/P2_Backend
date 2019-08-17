package com.bananas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bananas.entities.User;
import com.bananas.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	/**
	 * gets all users registered in the database
	 * @return a list of all users
	 */
	@GetMapping("")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	/**
	 * gets a user given a certain id
	 * @param id to search for
	 * @return a User object
	 */
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getById(id);
	}

	/**
	 * updates a User based on the field
	 * @param details contains the User with the changes
	 * @param field determines which field to update in pgSQL
	 * @param id of the user to update
	 * @return a response entity and updated user
	 */
	@PutMapping("/{field}/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User details, @PathVariable String field, @PathVariable int id) {
		User updatedUser = userService.getById(id);

		// Update field using switch
		switch (field) {
		case "email":
			updatedUser.setEmail(details.getEmail());
			break;
		case "password":
			updatedUser.setPassword(details.getPassword());
			break;
		case "name":
			if(!details.getFirstname().equals("")) {
				updatedUser.setFirstname(details.getFirstname());
			}
			if(!details.getLastname().equals("")) {
				updatedUser.setLastname(details.getLastname());
			}
		}

		// Update the record
		User update = userService.updateUser(updatedUser);

		// return updated user
		return ResponseEntity.ok().body(update);
	}

}
