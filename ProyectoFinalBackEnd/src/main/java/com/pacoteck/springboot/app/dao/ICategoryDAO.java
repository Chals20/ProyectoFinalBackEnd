package com.pacoteck.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacoteck.springboot.app.dto.Category;

public interface ICategoryDAO extends JpaRepository<Category, Long>{

}
