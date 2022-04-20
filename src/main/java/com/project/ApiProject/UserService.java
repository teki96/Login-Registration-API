package com.project.ApiProject;

import com.project.ApiProject.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;




public interface UserService extends UserDetailsService {
    User registerNewUser(UserDto userDto);
}
