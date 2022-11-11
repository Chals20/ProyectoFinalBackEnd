package dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDishDAO extends JpaRepository<Dish, Long>{
	
	//Elimina plato por id
	public void deleteById(Long id);
			
	//Busca y devuelve plato por id
	public Dish findByID(Long id);

}
