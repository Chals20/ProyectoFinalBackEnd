package dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.User;

public interface IUserDAO extends JpaRepository<User, Long>{
	
	//Elimina user por id
	public void deleteById(Long id);
	
	//Busca y devuelve usuario por id
	public Optional<User> findById(Long id);
	
	//Busca y devuelve usuario por el username
	public User findByUsername(String username);
	


}
