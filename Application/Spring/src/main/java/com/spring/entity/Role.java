package com.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.enums.RoleEnum;

import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name="role")
public class Role 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Role() {

    }
    
    public Role(RoleEnum name){
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public RoleEnum getName() {
        return this.name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }

}

