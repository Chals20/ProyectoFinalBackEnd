package com.pacoteck.springboot.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pacoteck.springboot.app.dto.Order;

public interface IOrderDAO extends JpaRepository<Order, Long>{

	@Query(value = "SELECT * FROM orders WHERE orders.users = :id AND fecha >= :date",
			nativeQuery = true)
	List<Order> findByIdAndDate(@Param("id") int id,@Param("date") LocalDate date );
}
