package com.pacoteck.springboot.app.service;

import java.util.List;

import com.pacoteck.springboot.app.dto.Role;

public interface IRoleService {

	// Métodos del CRUD
	public List<Role> listRoles(); // Listar All

	public Role saveOrder(Role role); // Guarda un rol CREATE

	public Role roleByID(Long id); // Leer datos del rol READ

	public Role updateRole(Role role); // Actualiza datos del rol UPDATE

	public void deleteRole(Long id);// Elimina rol DELETE
}
