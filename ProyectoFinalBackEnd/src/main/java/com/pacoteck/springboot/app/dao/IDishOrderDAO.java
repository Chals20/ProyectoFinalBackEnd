package com.pacoteck.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pacoteck.springboot.app.dto.DishOrder;

public interface IDishOrderDAO extends JpaRepository<DishOrder, Long>{
	


}
