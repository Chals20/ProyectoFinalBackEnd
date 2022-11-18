package com.pacoteck.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.dao.IOrderDAO;
import com.pacoteck.springboot.app.dto.Order;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	IOrderDAO daoOrder;
	
	@Override
	public List<Order> listOrders() {
		// TODO Auto-generated method stub
		return daoOrder.findAll();
	}

	@Override
	public com.pacoteck.springboot.app.dto.Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		return daoOrder.save(order);
	}

	@Override
	public Order orderByID(Long id) {
		// TODO Auto-generated method stub
		return daoOrder.findById(id).get();
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return daoOrder.save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		// TODO Auto-generated method stub
		daoOrder.deleteById(id);
	}

}
