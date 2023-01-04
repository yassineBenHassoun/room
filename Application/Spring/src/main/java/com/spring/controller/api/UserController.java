package com.spring.controller.api;


import com.spring.entity.User;
import com.spring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	// @PostConstruct
	// public void initRolesAndUsers() {
	// 	userService.initRolesAndUser();
	// }
	
	@PostMapping("/users")
	public User registerNewUser(@RequestBody User user) {
		return userService.createBasicUser(user);
	}
	
	@GetMapping("/forAdmin")
	@PreAuthorize("hasRole('ADMIN')")
	public String forAdmin() {
		return "you are locked to admin ";
	}
	
	@GetMapping("/forUser")
	@PreAuthorize("hasRole('USER')")
	public String forUser() {
		return "This url is only accessible to user";
	}
    
}
