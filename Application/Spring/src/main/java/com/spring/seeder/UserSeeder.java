package com.spring.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.spring.entity.User;
import com.spring.enums.RoleEnum;
import com.spring.repository.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class UserSeeder implements CommandLineRunner 
{
    @Autowired
    UserRepository userRepository;

    @Override
	public void run(String... args) throws Exception {
		generateUser();
	}

    private void generateUser(){

        if(userRepository.count() == 0) {

            User u1 = new User("yass","bnh","yasssinebnh","y.benhassoune@gmail.com","susanoo",0661265623);

            userRepository.save(u1);
        }
    }


}
