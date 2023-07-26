package com.TechBlog.blogappapis.services.impl;
import com.TechBlog.blogappapis.exceptions.*;
import com.TechBlog.blogappapis.payloads.UserDto;
import com.TechBlog.blogappapis.repositories.UserRepo;
import com.TechBlog.blogappapis.services.UserService;
import org.apache.catalina.UserDatabase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.TechBlog.blogappapis.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserRepo userRepo;
@Autowired
    private ModelMapper modelMapper;
    @Override
   public UserDto createUser(UserDto userDto){
        User user=this.dtoToUser(userDto);
       User savedUser= this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId){
        User user= this.userRepo.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        user.setEmployeeName(userDto.getEmployeeName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setReportsTo(userDto.getReportsTo());
        user.setProfileImage(userDto.getProfileImage());
        User updatedUser=this.userRepo.save(user);
       UserDto userDto1= this.userToDto(updatedUser);
        return userDto1;
    }
@Override
public UserDto getUserById(Integer userId){
    User user= this.userRepo.findById(userId).
            orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
    return this.userToDto(user);
}

    @Override
    public List<UserDto> getAllUsers(){
        List<User> users=this.userRepo.findAll();
        List<UserDto> usersDtos= users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return usersDtos;
    }

    @Override
    public  void deleteUser(Integer userId){
        User user= this.userRepo.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        this.userRepo.delete(user);
    }

private User dtoToUser(UserDto userDto){
        User user =this.modelMapper.map(userDto,User.class);
 //       user.setId(userDto.getId());
  //      user.setName(userDto.getName());
 //       user.setEmail(userDto.getEmail());
 //       user.setAbout(userDto.getAbout());
 //       user.setPassword(userDto.getPassword());
        return user;
}
public UserDto userToDto(User user){
        UserDto userDto= this.modelMapper.map(user,UserDto.class);
        return userDto;

}

}
