package com.pacoteck.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pacoteck.springboot.app.dao.IAlergenoDAO;
import com.pacoteck.springboot.app.dto.Alergeno;

public class AlergenoServiceImp implements IAlergenoService{
	
	@Autowired
	IAlergenoDAO dao;

	public List<Alergeno> findAll(){
		return dao.findAll();
	}
}
