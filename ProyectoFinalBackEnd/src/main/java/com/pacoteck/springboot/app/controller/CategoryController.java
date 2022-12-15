package com.pacoteck.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacoteck.springboot.app.dto.Category;
import com.pacoteck.springboot.app.service.CategoryServiceImpl;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryServiceImpl catServiceImpl;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/listAll")
	public List<Category> getCategories(){
		return catServiceImpl.listCategories();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save")
	public Category saveCategory(@RequestBody Category category) {
		return catServiceImpl.saveCategory(category);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findById/{id}")
	public Category categoryById(@PathVariable(name="id") Long id) {
		Category categoryID = new Category();
		
		categoryID = catServiceImpl.categoryByID(id);
		
		return categoryID;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update/{id}")
	public Category updateCategory(@PathVariable(name="id") Long id, @RequestBody Category cat) {
		
		Category cat_select = new Category();
		Category cat_update = new Category();
		
		cat_select = catServiceImpl.categoryByID(id);
		
		cat_select.setName(cat.getName());
		cat_select.setDish(cat.getDish());
		
		cat_update = catServiceImpl.updateCategory(cat_select);
		
		return cat_update;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{id}")
	public void deleteCategory(@PathVariable(name="id")Long id) {
		catServiceImpl.deleteCategory(id);
	}

}
