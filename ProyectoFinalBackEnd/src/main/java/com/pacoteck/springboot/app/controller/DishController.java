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

import com.pacoteck.springboot.app.dto.Dish;
import com.pacoteck.springboot.app.service.DishServiceImpl;

@RestController
@RequestMapping("/dishes")
public class DishController {

	@Autowired
	DishServiceImpl dishServiceImpl;
	
	@GetMapping("/listAll")
	public List<Dish> getDishes(){
		return dishServiceImpl.listDishes();
	}
	
	@PostMapping("/save")
	public Dish saveDish(@RequestBody Dish dish) {
		return dishServiceImpl.saveDish(dish);
	}
	
	@GetMapping("/findById/{id}")
	public Dish dishById(@PathVariable(name="id") Long id) {
		Dish dishID = new Dish();
		
		dishID = dishServiceImpl.dishByID(id);
		
		return dishID;
	}
	
	@PutMapping("/update/{id}")
	public Dish updateDish(@PathVariable(name="id") Long id, @RequestBody Dish dish) {
		
		Dish dish_select = new Dish();
		Dish dish_update = new Dish();
		
		dish_select = dishServiceImpl.dishByID(id);
		
		dish_select.setName(dish.getName());
		dish_select.setCategory(dish.getCategory());
		dish_select.setImg(dish.getImg());
		dish_select.setDishOrder(dish.getDishOrder());
		
		dish_update = dishServiceImpl.updateDish(dish_select);
		
		return dish_update;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteDish(@PathVariable(name="id")Long id) {
		dishServiceImpl.deleteDish(id);
	}
}
