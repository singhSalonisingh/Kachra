package com.TechBlog.blogappapis.services;

import com.TechBlog.blogappapis.payloads.UserDto;
import com.TechBlog.blogappapis.entities.User;

import java.util.List;

public interface UserService {
   UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
