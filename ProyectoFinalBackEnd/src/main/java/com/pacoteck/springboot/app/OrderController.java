package com.pacoteck.springboot.app;

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

import com.pacoteck.springboot.app.dto.Order;
import com.pacoteck.springboot.app.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@GetMapping("/listAll")
	public List<Order> getOrders(){
		return orderService.listOrders();
	}
	
	@PostMapping("/save")
	public Order saveOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/{id}")
	public Order orderById(@PathVariable(name="id") Long id) {
		Order orderID = new Order();
		
		orderID = orderService.orderByID(id);
		
		return orderID;
	}
	
	@PutMapping("/id")
	public Order updateOrder(@PathVariable(name="id") Long id, @RequestBody Order order) {
		
		Order order_select = new Order();
		Order order_update = new Order();
		
		order_select = orderService.orderByID(id);
		
		order_select.setUser(order.getUser());
		order_select.setDate(order.getDate());
		order_select.setDishorder(order.getDishorder());
		
		
		order_update = orderService.updateOrder(order_select);
		
		return order_update;
	}
	
	@DeleteMapping("/id")
	public void deleteOrder(@PathVariable(name="id")Long id) {
		orderService.deleteOrder(id);
	}

}
