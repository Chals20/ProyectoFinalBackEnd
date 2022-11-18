package com.pacoteck.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.dao.ICategoryDAO;
import com.pacoteck.springboot.app.dto.Category;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	ICategoryDAO daoCategory;
	
	@Override
	public List<Category> listCategories() {
		// TODO Auto-generated method stub
		return daoCategory.findAll();
	}

	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return daoCategory.save(category);
	}

	@Override
	public Category categoryByID(Long id) {
		// TODO Auto-generated method stub
		return daoCategory.findById(id).get();
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return daoCategory.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		daoCategory.deleteById(id);
	}

}
