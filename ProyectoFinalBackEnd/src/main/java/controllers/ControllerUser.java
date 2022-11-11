package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.User;
import service.UserServiceImp;

@RestController
@RequestMapping("/p1")
public class ControllerUser {
	
	
	@Autowired
	UserServiceImp u;
	
	@GetMapping("/user")
	public List<User> listarUsers(){
		return u.findAll();
	}

}
