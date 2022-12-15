package com.spring.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.spring.entity.Role;
import com.spring.enums.RoleEnum;
import com.spring.repository.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder implements CommandLineRunner
{
    @Autowired
    RoleRepository roleRepository;
    
    @Override
	public void run(String... args) throws Exception {
		implementRole();
	}

    private void implementRole() {

        if(roleRepository.count() == 0) {

         
            Role r1 = new Role(RoleEnum.SUPER_ADMIN.toString());
            Role r2 = new Role(RoleEnum.ADMIN.toString());
            Role r3 = new Role(RoleEnum.CUSTOMER.toString());

            roleRepository.save(r1);
            roleRepository.save(r2);
            roleRepository.save(r3);
 
        }
    }
}
