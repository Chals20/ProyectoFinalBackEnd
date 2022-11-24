package com.pacoteck.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacoteck.springboot.app.dao.IRoleDAO;
import com.pacoteck.springboot.app.dto.Role;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	IRoleDAO daoRole;
	
	@Override
	public List<Role> listRoles() {
		// TODO Auto-generated method stub
		return daoRole.findAll();
	}

	@Override
	public Role saveOrder(Role role) {
		// TODO Auto-generated method stub
		return daoRole.save(role);
	}

	@Override
	public Role roleByID(Long id) {
		// TODO Auto-generated method stub
		return daoRole.findById(id).get();
	}

	@Override
	public Role updateRole(Role role) {
		// TODO Auto-generated method stub
		return daoRole.save(role);
	}

	@Override
	public void deleteRole(Long id) {
		// TODO Auto-generated method stub
		daoRole.deleteById(id);
	}

}
