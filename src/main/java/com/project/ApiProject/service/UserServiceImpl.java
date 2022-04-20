package com.project.ApiProject.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.project.ApiProject.model.Role;
import com.project.ApiProject.model.User;
import com.project.ApiProject.repository.UserRepository;
import com.project.ApiProject.web.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.ApiProject.web.dto.*;
import com.project.ApiProject.config.*;
import com.project.ApiProject.model.*;
import com.project.ApiProject.repository.*;
import com.project.ApiProject.service.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;



    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
	public User registerNewUser(UserDto registrationDto) {
		User user = new User(registrationDto.getUsername(), 
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(username == null){
            throw new UsernameNotFoundException("No such user: " + username);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRoles(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRoles(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }
}
