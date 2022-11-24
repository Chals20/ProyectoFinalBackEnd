package com.pacoteck.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacoteck.springboot.app.dto.Role;
import com.pacoteck.springboot.app.service.IRoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	IRoleService roleService;
	
	@GetMapping("/listAll")
	public List<Role> getRoles(){
		return roleService.listRoles();
	}
	
	@PostMapping("/save")
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveOrder(role);
	}
	
	@GetMapping("/findById/{id}")
	public Role roleById(@PathVariable(name="id") Long id) {
		Role roleID = new Role();
		
		roleID = roleService.roleByID(id);
		
		return roleID;
	}
	
	@PutMapping("/update/{id}")
	public Role updateRole(@PathVariable(name="id") Long id, @RequestBody Role role) {
		
		Role role_select = new Role();
		Role role_update = new Role();
		
		role_select = roleService.roleByID(id);
		
		role_select.setName(role.getName());
		role_select.setUser(role.getUser());
		
		role_update = roleService.updateRole(role_select);
		
		return role_update;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteRole(@PathVariable(name="id")Long id) {
		roleService.deleteRole(id);
	}

}
