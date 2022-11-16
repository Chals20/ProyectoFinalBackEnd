package com.pacoteck.springboot.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pacoteck.springboot.app.dto.User;
import com.pacoteck.springboot.app.service.UserServiceImp;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServiceImp imp;
	
	
	@GetMapping("/findAll")
	public List<User> findAll(){
		return imp.findAll();
	}
}
