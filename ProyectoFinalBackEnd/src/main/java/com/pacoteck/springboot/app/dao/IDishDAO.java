package com.pacoteck.springboot.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.pacoteck.springboot.app.dto.Dish;

public interface IDishDAO extends JpaRepository<Dish, Long>{

	@Query(value = "SELECT * FROM dishs WHERE dishs.namee LIKE %:name%"
			+ " AND dishs.price BETWEEN :pmin AND :pmax",
			nativeQuery = true)
	List<Dish> findByQuery(@Param("name") String name,@Param("pmin") int pmin,
			@Param("pmax") int pmax);
	
	@Query(value = "SELECT dishs.id,dishs.namee,dishs.img,dishs.price,dishs.category,dishs.alergeno "
			+ "FROM orders JOIN dish_order ON orders.id = dish_order.orden " + 
			"JOIN dishs ON dishs.id = dish_order.dish " +
			"WHERE orders.id = :ticket",
			nativeQuery = true)
	List<Dish> findByOrder(@Param("ticket") int ticket);
}
