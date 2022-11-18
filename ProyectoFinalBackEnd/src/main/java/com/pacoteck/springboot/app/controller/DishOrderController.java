package com.pacoteck.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacoteck.springboot.app.dto.DishOrder;
import com.pacoteck.springboot.app.service.IDishOrderService;

@RestController
@RequestMapping("/dishorders")
public class DishOrderController {

	@Autowired
	IDishOrderService dishOrderService;
	
	@GetMapping("/listAll")
	public List<DishOrder> getDishOrders(){
		return dishOrderService.listDishOrders();
	}
	
	@PostMapping("/save")
	public DishOrder saveDishOrder(@RequestBody DishOrder dishOrder) {
		return dishOrderService.saveDishOrder(dishOrder);
	}
	
	@GetMapping("/{id}")
	public DishOrder dishOrderById(@PathVariable(name="id") Long id) {
		DishOrder dishOrderID = new DishOrder();
		
		dishOrderID = dishOrderService.dishOrderByID(id);
		
		return dishOrderID;
	}
	
	@PutMapping("/id")
	public DishOrder updateDishOrder(@PathVariable(name="id") Long id, @RequestBody DishOrder dishOrder) {
		
		DishOrder dishOrder_select = new DishOrder();
		DishOrder dishOrder_update = new DishOrder();
		
		dishOrder_select = dishOrderService.dishOrderByID(id);
		
		dishOrder_select.setDish(dishOrder.getDish());
		dishOrder_select.setOrden(dishOrder.getOrden());
		
		dishOrder_update = dishOrderService.updateDishOrder(dishOrder_select);
		
		return dishOrder_update;
	}
	
	@DeleteMapping("/id")
	public void deleteDishOrder(@PathVariable(name="id")Long id) {
		dishOrderService.deleteDishOrder(id);
	}
}
