package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImp implements IRolesService{
	
	@Autowired
	IRoleDAO irdao;

	@Override
	public Role findAll() {
		// TODO Auto-generated method stub
		return irdao.findAll();
	}

	@Override
	public void delete(Long id) {
		irdao.deleteById(id);
		
	}

	@Override
	public void createUpdate(Role role) {
		irdao.save(role);
		
	}


	
	
}
