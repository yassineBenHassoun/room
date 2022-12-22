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
public class UserService {
    

    @Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User registerNewUser(User user) {
		Role role = roleRepo.findById("User").get();
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));
		return userRepo.save(user);
	}
	
	public void initRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleRepo.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created record");
		roleRepo.save(userRole);
		
		User adminUser = new User();
		adminUser.setUserName("admin123");
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserPassword(getEncodedPassword("admin@12345"));
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);	
		adminUser.setRoles(adminRoles);
		userRepo.save(adminUser);
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
