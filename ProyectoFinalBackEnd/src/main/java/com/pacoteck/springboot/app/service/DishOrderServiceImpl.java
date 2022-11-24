package com.pacoteck.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.dao.IDishOrderDAO;
import com.pacoteck.springboot.app.dto.DishOrder;

@Service
public class DishOrderServiceImpl implements IDishOrderService{

	@Autowired
	IDishOrderDAO daoDishOrder;
	
	@Override
	public List<DishOrder> listDishOrders() {
		// TODO Auto-generated method stub
		return daoDishOrder.findAll();
	}

	@Override
	public DishOrder saveDishOrder(DishOrder dishOrder) {
		// TODO Auto-generated method stub
		return daoDishOrder.save(dishOrder);
	}

	@Override
	public DishOrder dishOrderByID(Long id) {
		// TODO Auto-generated method stub
		return daoDishOrder.findById(id).get();
	}

	@Override
	public DishOrder updateDishOrder(DishOrder dishOrder) {
		// TODO Auto-generated method stub
		return daoDishOrder.save(dishOrder);
	}

	@Override
	public void deleteDishOrder(Long id) {
		// TODO Auto-generated method stub
		daoDishOrder.deleteById(id);
	}

}
