package com.pacoteck.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacoteck.springboot.app.dto.Order;

public interface IOrderDAO extends JpaRepository<Order, Long>{

}
