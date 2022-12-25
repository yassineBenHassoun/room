package com.spring.service;
import java.util.HashSet;
import java.util.Set;

import com.spring.entity.Role;
import com.spring.entity.User;
import com.spring.enums.RoleEnum;
import com.spring.repository.RoleRepository;
import com.spring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	public User registerNewUser(User user) {
		Role adminRole = roleRepo.findByRoleName(RoleEnum.USER.name());
		Set<Role> roles = new HashSet<>();
		roles.add(adminRole);
		user.setRoles(roles);
		user.setUserPassword(encoder.encode(user.getUserPassword()));
		return userRepo.save(user);
	}
	
}
