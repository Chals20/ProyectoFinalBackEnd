package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO extends JpaRepository<User, Long>{
	
	//Elimina user por id
	public void deleteById(Long id);
	
	//Busca y devuelve usuario por id
	public User findByID(Long id);
	
	//Busca y devuelve usuario por el username
	public User findByUsername(String username);

}
