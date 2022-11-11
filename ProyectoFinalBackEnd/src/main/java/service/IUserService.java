package service;

import java.util.List;

public interface IUserService {
	
	
	public List<User> findAll();
	public Boolean logIn(String password, String userName);
	public void createUpdate(User user);
	public void deleteById(Long id);
	public User findById(Long id);
	public User findByUserName(String userName);
	public List<User> findByRole(Long id);
	
}
