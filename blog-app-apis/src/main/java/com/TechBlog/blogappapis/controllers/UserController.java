package com.TechBlog.blogappapis.controllers;

import com.TechBlog.blogappapis.payloads.ApiResponse;
import com.TechBlog.blogappapis.payloads.UserDto;
import com.TechBlog.blogappapis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
public class UserController {
    @Autowired
    private UserService userService;
    //POST- create user
   @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto=this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
    //PUT- update user
    @PutMapping("/{userId}") //{userId} is path variable in the language of spring
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId") Integer uid)
    //agr userId ka name kuch aur likhna hai then try above . and if same hai then try  @PathVariable Integer userId
    {
       UserDto updatedUser= this.userService.updateUser(userDto, uid);
       return  ResponseEntity.ok(updatedUser);
    }

    //DELETE- delete user
    @DeleteMapping("/{userId}")
public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
      this.userService.deleteUser(uid);
      return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }


    //GET-  get user
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
       return ResponseEntity.ok(this.userService.getAllUsers());
    }

    //get Single user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
