package com.project.ApiProject.service;

import com.project.ApiProject.model.User;
import com.project.ApiProject.web.dto.UserDto;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.ApiProject.web.dto.*;
import com.project.ApiProject.config.*;
import com.project.ApiProject.model.*;
import com.project.ApiProject.repository.*;
import com.project.ApiProject.service.*;


public interface UserService extends UserDetailsService {
    User registerNewUser(UserDto userDto);
}
