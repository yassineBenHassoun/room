package com.spring.service;

import com.spring.entity.Role;
import com.spring.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService 
{
    
        @Autowired
        private RoleRepository roleRepo;
        
        public Role createNewRole(Role role) {
            return roleRepo.save(role);
	}
}
