package com.spring.service;
import java.util.HashSet;
import java.util.Set;

import com.spring.entity.Role;
import com.spring.entity.User;
import com.spring.repository.RoleRepository;
import com.spring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService 
{
    @Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder encoder;


	public User createBasicUser(User user) {

		if (roleRepository.count() > 0) {

			Role userRole = roleRepository.findByName("USER");
			Set<Role> roles = new HashSet<>();
			roles.add(userRole);
			user.setRoles(roles);
			user.setPassword(encoder.encode(user.getPassword()));
			
			return userRepository.save(user);

		}
		return user;	
	}
}
