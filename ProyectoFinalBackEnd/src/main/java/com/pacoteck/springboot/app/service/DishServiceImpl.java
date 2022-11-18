package com.pacoteck.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.dao.IDishDAO;
import com.pacoteck.springboot.app.dto.Dish;

@Service
public class DishServiceImpl implements IDishService{

	@Autowired
	IDishDAO daoDish;
	
	@Override
	public List<Dish> listDishes() {
		// TODO Auto-generated method stub
		return daoDish.findAll();
	}

	@Override
	public Dish saveDish(Dish dish) {
		// TODO Auto-generated method stub
		return daoDish.save(dish);
	}

	@Override
	public Dish dishByID(Long id) {
		// TODO Auto-generated method stub
		return daoDish.findById(id).get();
	}

	@Override
	public Dish updateDish(Dish dish) {
		// TODO Auto-generated method stub
		return daoDish.save(dish);
	}

	@Override
	public void deleteDish(Long id) {
		// TODO Auto-generated method stub
		daoDish.deleteById(id);
	}

}
