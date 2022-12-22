package com.spring.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User 
{

    @Id
	private String userName;
	
	private String userFirstName;
	
	private String userLastName;
	
	private String userPassword;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", 
			joinColumns = {
					@JoinColumn(name = "user_id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "role_id")
			}
	)
	private Set<Role> roles;
    
}
