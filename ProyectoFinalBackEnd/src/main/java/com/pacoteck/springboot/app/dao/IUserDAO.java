package com.pacoteck.springboot.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacoteck.springboot.app.dto.User;

public interface IUserDAO extends JpaRepository<User, Long>{
	public Optional<User> findByUsername(String username);
}
