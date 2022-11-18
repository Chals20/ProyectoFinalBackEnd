package com.pacoteck.springboot.app.service;

import java.util.List;

import com.pacoteck.springboot.app.dto.DishOrder;

public interface IDishOrderService {

	// Métodos del CRUD
	public List<DishOrder> listDishOrders(); // Listar All

	public DishOrder saveDishOrder(DishOrder dishOrder); // Guarda un plato pedido CREATE

	public DishOrder dishOrderByID(Long id); // Leer datos del plato pedido READ

	public DishOrder updateDishOrder(DishOrder dishOrder); // Actualiza datos de plato pedido UPDATE

	public void deleteDishOrder(Long id);// Elimina plato pedido DELETE
}
