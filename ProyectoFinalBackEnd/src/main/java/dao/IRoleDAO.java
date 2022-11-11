package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Role;

public interface IRoleDAO extends JpaRepository<Role, Long>{

	//Elimina roles por id
	public void deleteById(Long id);
	
	//Busca y devuelve el rol por id
	public Optional<Role> findById(Long id);

}
