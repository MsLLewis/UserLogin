package com.lewis.userlogin.service;

import com.lewis.userlogin.dto.UserDto;
import com.lewis.userlogin.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    void saveUser(UserDto userDto);
    User findByEmail(String email);
    List<UserDto>findAllUsers();
}
