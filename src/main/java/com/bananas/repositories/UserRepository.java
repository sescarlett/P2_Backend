package com.bananas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bananas.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
