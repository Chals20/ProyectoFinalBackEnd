package com.pacoteck.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.dao.IUserDAO;
import com.pacoteck.springboot.app.dto.User;

@Service
public class UserServiceImp implements IUserService{

	@Autowired
	IUserDAO dao;

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public void create(User user) {
		dao.save(user);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
		
	}

	@Override
	public Optional<User> findById(Long id) {
		Optional<User> user = dao.findById(id);
		return user;
	}

	@Override
	public Boolean findByUserName(String userName) {
		Optional<User> user = dao.findByUsername(userName);
		return !(user.isEmpty());
	}
	
	public Boolean findByEmail(String email) {
		Optional<User> user = dao.findByEmail(email);
		return !(user.isEmpty());
	}
	
	public User logIn(String email, String password) {
		return dao.logIn(email, password);
	}
	
	

}
