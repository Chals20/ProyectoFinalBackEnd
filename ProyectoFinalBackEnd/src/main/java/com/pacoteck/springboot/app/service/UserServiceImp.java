package com.pacoteck.springboot.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.dao.IUserDAO;
import com.pacoteck.springboot.app.dto.User;

@Service
public class UserServiceImp implements IUserService {

	@Autowired
	IUserDAO iUserDAO;

	@Override
	public List<User> findAll() {
		return iUserDAO.findAll();
	}

	/*
	 * @Override public Boolean logIn(String password, String userName) { List<User>
	 * listUser = iudao.findAll(); for (User user : listUser) {
	 * if(user.getPassword().equals(password) &&
	 * user.getUsername().equals(userName)) { return true; } } return false; }
	 */

	@Override
	public User createUser(User user) {

		return iUserDAO.save(user);
	}

	@Override
	public void deleteById(Long id) {
		iUserDAO.deleteById(id);

	}

	@Override
	public User findById(Long id) {
		return iUserDAO.findById(id).get();
	}

	@Override
	public User findByUserName(String userName) {
		return iUserDAO.findByUsername(userName);
	}

	/*
	 * //sin uso
	 * 
	 * @Override public List<User> findByIdRole(Long idRole) { return
	 * iUserDAO.findByIdRole(idRole);
	 * 
	 * }
	 */

}
