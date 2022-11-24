package com.pacoteck.springboot.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacoteck.springboot.app.dto.Alergeno;

public interface IAlergenoDAO extends JpaRepository<Alergeno, Long>{

}
