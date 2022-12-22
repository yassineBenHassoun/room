package com.spring.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

import com.spring.entity.Role;
import com.spring.entity.User;
import com.spring.enums.RoleEnum;
import com.spring.repository.RoleRepository;
import com.spring.repository.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class UserSeeder implements CommandLineRunner 
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
	public void run(String... args) throws Exception {
		generateUser();
	}

    private void generateUser(){

        if(userRepository.count() == 0) {

            User u1 = new User("yass","bnh","superadmin","y.benhassoune@gmail.com",encoder.encode("susanoo"),0661265623);

            Set<Role> roles = new  HashSet<>();
            Role userRole = roleRepository.findByName(RoleEnum.USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            Role adminRole = roleRepository.findByName(RoleEnum.ADMIN).orElseThrow(() -> new RuntimeException("Error: Role Admin is not found."));
            roles.add(adminRole);
            Role modRole = roleRepository.findByName(RoleEnum.MODERATOR).orElseThrow(() -> new RuntimeException("Error: Modo is not found."));
            roles.add(modRole);

            u1.setRoles(roles);
            userRepository.save(u1);
  
        }
    }


}
