package com.pacoteck.springboot.app.service;

import java.util.ArrayList;
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

	public List<Dish> sixDish() {
		List<Dish> aux = daoDish.findAll();
		int n[] = new int[6];
		for (int i = 0; i < 6; i++) {
			int numero = (int)(Math.random()* aux.size());
			n[i] = numero;
		}
		int count = 0;
		List<Dish> send = new ArrayList<Dish>();
		for (Dish dish : aux) {
			if(count == n[0] || count == n[1] || count == n[2] || count == n[3] ||
					count == n[4] || count == n[5] ) {
				//System.out.println(dish.);
				send.add(dish);
			}
			count++;
		}
		return send;
	}
}
