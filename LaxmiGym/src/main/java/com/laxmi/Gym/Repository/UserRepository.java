package com.laxmi.Gym.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laxmi.Gym.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
