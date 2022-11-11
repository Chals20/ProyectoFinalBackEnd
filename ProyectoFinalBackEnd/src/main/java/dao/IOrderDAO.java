package dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDAO extends JpaRepository<Order, Long>{
	
	//Elimina order por id
	public void deleteById(Long id);
		
	//Busca y devuelve order por id
	public Order findByID(Long id);

}
