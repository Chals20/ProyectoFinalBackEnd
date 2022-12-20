package com.pacoteck.springboot.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacoteck.springboot.app.dto.User;
import com.pacoteck.springboot.app.service.UserServiceImp;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserServiceImp userServiceImp;

	// Retorna todos los usuarios
	@GetMapping("/findAll")
	public List<User> findAll() {
		return userServiceImp.findAll();
	}

	// Retorna un usuario a traves del id
	@GetMapping("/findById/{id}")
	public Optional<User> findById(@PathVariable(name = "id") Long id) {
		return userServiceImp.findById(id);
	}

	// Retorna un usuario a traves del username
	@GetMapping("/findByUsername/{username}")
	public Boolean findByUserName(@PathVariable(name = "username") String username) {
		return userServiceImp.findByUserName(username);
	}
	
	// Retorna un usuario a traves del username
	@GetMapping("/findByEmail/{email}")
	public Boolean findByEmail(@PathVariable(name = "email") String email) {
		return userServiceImp.findByEmail(email);
	}

	// Actualizar cliente existente
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable(name = "id") Long id, @RequestBody User user) {
		Optional<User> user1 = userServiceImp.findById(id);
		if(!user1.isEmpty()) {
			user.setId(id);
			userServiceImp.create(user);
			return "User update";
		}
		return "user no encontrado";
	}

	
	//Crea un nuevo usuario
	@PostMapping("/save")
	public void create(@RequestBody User user) {
		userServiceImp.create(user);

	}

	// Elimina un usuario a traves de su id //FALLA
	@DeleteMapping("/deleteById/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userServiceImp.deleteById(id);
	}
	
	@GetMapping("/logIn/{email}/{password}")
	public User logIn(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		return userServiceImp.logIn(email, password);
	}
	
	@GetMapping("/updatepassword/{id}/{password}")
	public void updatePassword(@PathVariable("id") Long id,
			@PathVariable("password") String password) {
		userServiceImp.UpdatePassword(id, password);
	}
	
	//@GetMapping("/exist/{name}/{email}")
	//public Boolean[] exist(@Param("name") String name,@Param("name") String email) {
		//return userServiceImp.userExist(name, email);
	//}

	/*
	 * //listar Clientes por campo nombre
	 * 
	 * @GetMapping("/clientes/nombre/{nombre}") public List<Trabajador>
	 * listarClienteNombre(@PathVariable(name="nombre") String nombre) { return
	 * clienteServideImpl.listarClienteNomnbre(nombre); }
	 * 
	 * 
	 * @PostMapping("/clientes") public Trabajador salvarCliente(@RequestBody
	 * Trabajador cliente) {
	 * 
	 * return clienteServideImpl.guardarCliente(cliente); }
	 * 
	 * 
	 * 
	 * 
	 * @PutMapping("/clientes/{id}") public Trabajador
	 * actualizarCliente(@PathVariable(name="id")Long id,@RequestBody Trabajador
	 * cliente) {
	 * 
	 * Trabajador cliente_seleccionado= new Trabajador(); Trabajador
	 * cliente_actualizado= new Trabajador();
	 * 
	 * cliente_seleccionado= clienteServideImpl.clienteXID(id);
	 * 
	 * cliente_seleccionado.setNombre(cliente.getNombre());
	 * cliente_seleccionado.setApellido(cliente.getApellido());
	 * cliente_seleccionado.setDireccion(cliente.getDireccion());
	 * cliente_seleccionado.setDni(cliente.getDni());
	 * cliente_seleccionado.setFecha(cliente.getFecha());
	 * 
	 * cliente_actualizado =
	 * clienteServideImpl.actualizarCliente(cliente_seleccionado);
	 * 
	 * System.out.println("El cliente actualizado es: "+ cliente_actualizado);
	 * 
	 * return cliente_actualizado; }
	 * 
	 * @DeleteMapping("/clientes/{id}") public void
	 * eleiminarCliente(@PathVariable(name="id")Long id) {
	 * clienteServideImpl.eliminarCliente(id); }
	 */

}
