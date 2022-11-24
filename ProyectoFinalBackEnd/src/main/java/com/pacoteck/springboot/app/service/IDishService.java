package com.pacoteck.springboot.app.service;

import java.util.List;

import com.pacoteck.springboot.app.dto.Dish;

public interface IDishService {

	// Métodos del CRUD
	public List<Dish> listDishes(); // Listar All

	public Dish saveDish(Dish dish); // Guarda un plato CREATE

	public Dish dishByID(Long id); // Leer datos del plato READ

	public Dish updateDish(Dish dish); // Actualiza datos del plato UPDATE

	public void deleteDish(Long id);// Elimina plato DELETE
}
