package service;

import java.util.List;

import dto.Role;

public interface IRolesService{
	
	public List<Role> findAll();
	public void delete(Long id);
	public void createUpdate(Role role);
	
}
