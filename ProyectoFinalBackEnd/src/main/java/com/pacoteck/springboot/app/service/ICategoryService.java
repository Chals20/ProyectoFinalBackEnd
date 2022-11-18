package com.pacoteck.springboot.app.service;

import java.util.List;

import com.pacoteck.springboot.app.dto.Category;

public interface ICategoryService {
	
	// Métodos del CRUD
	public List<Category> listCategories(); // Listar All

	public Category saveCategory(Category category); // Guarda una categoria CREATE

	public Category categoryByID(Long id); // Leer datos de categoria READ

	public Category updateCategory(Category category); // Actualiza datos de la categoria UPDATE

	public void deleteCategory(Long id);// Elimina categoría DELETE

}
