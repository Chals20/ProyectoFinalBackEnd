package service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService{
	
	IUserDAO iudao;

	@Override
	public List<User> findAll() {
		return iudao.findAll();
	}

	@Override
	public Boolean logIn(String password, String userName) {
		List<User> listUser = iudao.findAll();
		for (User user : listUser) {
			if(user.getPassword().equals(password) && user.getUserName().equals(userName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void createUpdate(User user) {
		iudao.save(user);
	}

	@Override
	public void deleteById(Long id) {
		iudao.deleteById(id);
		
	}

	@Override
	public User findById(Long id) {
		return iudao.findById(id);
	}

	@Override
	public User findByUserName(String userName) {
		return iudao.findByUserName(userName);
	}

	@Override
	public List<User> findByRole(Long id) {
		return iudao.findByRole(id);
	}
	

}
