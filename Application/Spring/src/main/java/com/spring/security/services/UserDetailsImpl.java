package com.spring.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.entity.User;

@Service
public class UserDetailsImpl implements UserDetails 
{
    
    private static final Long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String email;
  
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(){}
    
    public UserDetailsImpl(Integer id, String username, String email, String password,Collection<? extends GrantedAuthority> authorities) {
      this.id = id;
      this.username = username;
      this.email = email;
      this.password = password;
      this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        
        List<GrantedAuthority> authority = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), authority);
      }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
    }
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      UserDetailsImpl user = (UserDetailsImpl) o;
      return Objects.equals(id, user.id);
    }
  
  
}
