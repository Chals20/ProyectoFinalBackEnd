package com.pacoteck.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacoteck.springboot.app.dto.Dish;

public interface IDishDAO extends JpaRepository<Dish, Long>{

}
