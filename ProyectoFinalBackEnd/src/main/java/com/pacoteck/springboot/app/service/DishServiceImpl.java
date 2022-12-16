package com.pacoteck.springboot.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.dao.IDishDAO;
import com.pacoteck.springboot.app.dto.Alergeno;
import com.pacoteck.springboot.app.dto.Busqueda;
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

	//return  6 dish
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
				send.add(dish);
			}
			count++;
		}
		return send;
	}
	
	//findByquery in IDishDAO
	public List<Dish> findByName(String name,int pmin,int pmax){
		return daoDish.findByQuery(name,pmin,pmax);
	}
	
	public List<Dish> search(Busqueda busqueda){
		List<Dish> dishList = findByName(busqueda.getName(),busqueda.getPmin(),busqueda.getPmax());
		List<Dish> result = new ArrayList<Dish>();
		System.out.println("for");
		for (Dish dish : dishList) {
			System.out.println(controlAlergenos(busqueda,dish.getAlergeno())+" "+ dish.getName());
			boolean flagAlergeno = controlAlergenos(busqueda,dish.getAlergeno());
			boolean flagCategory = controlCategorias(busqueda, dish.getCategory().getId());
			if(flagCategory) if(flagAlergeno) result.add(dish);		
		}
		return result;
	}
	
	
	//retorna true si cumple con los 3 alergenos;
	public boolean controlAlergenos(Busqueda busqueda,Alergeno alergenos) {
		if(busqueda.isGlutten()) {
			if(alergenos.isGluten()){
				return false;}}
		if(busqueda.isVegan()) {
			if(alergenos.isVegan()){
				return false;}}
		if(busqueda.isLactosa()) {
			if(alergenos.isLacteos()){
				return false;}}
		
		return true;
	}
	
	public boolean controlCategorias(Busqueda busqueda,Long n) {
		if(busqueda.getType() == 0) return true;
		if(busqueda.getType() == n) { return true;
		}else return false;
	}
}
