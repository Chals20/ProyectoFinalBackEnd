package service;


public interface IRolesService{
	
	public Role findAll();
	public void delete(Long id);
	public void createUpdate(Role role);
	
}
