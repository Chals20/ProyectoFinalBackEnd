package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IUserDAO;
import dto.User;


@Service
public class UserServiceImp implements IUserService{
	
	@Autowired
	IUserDAO iudao;

	@Override
	public List<User> findAll() {
		return iudao.findAll();
	}

	@Override
	public Boolean logIn(String password, String userName) {
		List<User> listUser = iudao.findAll();
		for (User user : listUser) {
			if(user.getPassword().equals(password) && user.getUsername().equals(userName)) {
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
	public Optional<User> findById(Long id) {
		return iudao.findById(id);
	}

	@Override
	public User findByUserName(String userName) {
		return iudao.findByUsername(userName);
	}

	
	//sin uso
	@Override
	public List<User> findByIdRole(Long id) {
		// TODO Auto-generated method stub
		return null;
	}




	

}
