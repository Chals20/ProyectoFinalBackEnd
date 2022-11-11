package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDAO extends JpaRepository<Role, Long>{

	//Elimina roles por id
	public void deleteById(Long id);
	
	//Busca y devuelve el rol por id
	public Role findById(Long id);

}
