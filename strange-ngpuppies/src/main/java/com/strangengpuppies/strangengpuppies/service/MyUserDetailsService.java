package com.strangengpuppies.strangengpuppies.service;

import com.strangengpuppies.strangengpuppies.dao.base.UserDao;
import com.strangengpuppies.strangengpuppies.model.Role;
import com.strangengpuppies.strangengpuppies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service ("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
  
  @Autowired
  private UserDao userDao;
  
  @Transactional (readOnly = true)
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userDao.findUserByUsername(username);
    Collection<? extends GrantedAuthority> authorities = buildUserAuthority(user.getRole());
    
    
    return buildUserForAuthentication(user, authorities);
  }
  
  private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, Collection<? extends GrantedAuthority> authorities) {
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
  }
  
  private Collection<? extends GrantedAuthority> buildUserAuthority(Role role) {
    List<String> roles = new ArrayList<>();
    roles.add("ROLE_" + role.getName());
    
    return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
  }
}