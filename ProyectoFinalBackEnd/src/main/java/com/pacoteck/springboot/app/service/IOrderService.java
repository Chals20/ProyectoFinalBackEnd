package com.pacoteck.springboot.app.service;

import java.util.List;

import com.pacoteck.springboot.app.dto.Order;

public interface IOrderService {

	// Métodos del CRUD
	public List<Order> listOrders(); // Listar All

	public Order saveOrder(Order order); // Guarda una orden CREATE

	public Order orderByID(Long id); // Leer datos de la orden READ

	public Order updateOrder(Order order); // Actualiza datos de la orden UPDATE

	public void deleteOrder(Long id);// Elimina orden DELETE
	
}
