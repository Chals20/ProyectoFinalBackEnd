package com.pacoteck.springboot.app.service;

import java.util.List;
import com.pacoteck.springboot.app.dto.User;

public interface IUserService {

	public List<User> findAll();

	// public Boolean logIn(String password, String userName);
	public User createUser(User user);

	public void deleteById(Long id);

	public User findById(Long id);

	public User findByUserName(String userName);

	//public List<User> findByIdRole(Long id);

}
