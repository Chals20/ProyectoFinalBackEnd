package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Category;

public interface ICategoryDAO extends JpaRepository<Category, Long>{
	
	//Elimina categoria por id
	public void deleteById(Long id);
			
	//Busca y devuelve categoria por id
	public Category findByID(Long id);
}
