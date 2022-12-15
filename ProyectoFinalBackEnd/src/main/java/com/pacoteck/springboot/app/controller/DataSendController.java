package com.pacoteck.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacoteck.springboot.app.dataAnalysis.DataEntity;
import com.pacoteck.springboot.app.dto.Dish;
import com.pacoteck.springboot.app.dto.DishOrder;
import com.pacoteck.springboot.app.service.DishOrderServiceImpl;
import com.pacoteck.springboot.app.service.DishServiceImpl;

@RestController
@RequestMapping("/data")
public class DataSendController {
	@Autowired
	DishOrderServiceImpl orderDishImp;
	
	@Autowired
	DishServiceImpl dishServiceImpl;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/salesAll")
	public List<DataEntity> salesAll(){
		List<DataEntity> aux = new ArrayList<DataEntity>();
		List<Dish> dishes = dishServiceImpl.listDishes();
		List<DishOrder> orders = orderDishImp.listDishOrders();
		for (Dish dish : dishes) {
			// create a new list dish whit counts in 0;
			DataEntity newData = new DataEntity(dish.getName(),0,dish.getCategory().getName());
			aux.add(newData);
		}
		for (DishOrder dishOrder : orders) {
			for (DataEntity de : aux) {
				if(dishOrder.getDish().getName().equals(de.getName())) {
					de.setCount(de.getCount()+1);
					break;
				}
			}
			
		}
		return aux;
	}
	
}
