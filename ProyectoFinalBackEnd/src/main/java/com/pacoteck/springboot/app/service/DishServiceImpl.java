package com.pacoteck.springboot.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.dao.IDishDAO;
import com.pacoteck.springboot.app.dto.Alergeno;
import com.pacoteck.springboot.app.dto.Busqueda;
import com.pacoteck.springboot.app.dto.Dish;
import com.pacoteck.springboot.app.dto.DishPlus;

@Service
public class DishServiceImpl implements IDishService{

	@Autowired
	IDishDAO daoDish;
	
	@Override
	public List<Dish> listDishes() {
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

	//return  8 dish
	public List<Dish> firstList() {
		List<Dish> aux = daoDish.findAll();
		Collections.shuffle(aux); 
		List<Dish> send = new ArrayList<Dish>();
		int count = 0;
		for (Dish dish : aux) {
			if((count <= 7)){
				send.add(dish);
				count++;}
			else {break;}
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
	
	//return  true if categorys is same
	public boolean controlCategorias(Busqueda busqueda,Long n) {
		if(busqueda.getType() == 0) return true;
		if(busqueda.getType() == n) { return true;
		}else return false;
	}
	
	public List<DishPlus> findByOrder(int id){
		List<DishPlus> list = daoDish.findByOrder(id);
		for (DishPlus dishPlus : list) {
			System.out.println(dishPlus.toString());
		}
		return list;
	}
}
