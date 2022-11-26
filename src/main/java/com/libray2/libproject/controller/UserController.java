package com.libray2.libproject.controller;

import com.libray2.libproject.Entity.User;
import com.libray2.libproject.dto.UserDto;
import com.libray2.libproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) throws Exception{
        return  userService.getUserById(id);
    }

    @PostMapping
    public UserDto saveUser(@RequestBody User user){
        System.out.println(user);
        return userService.saveUser(user);
    }

    @PostMapping("search")
    public List<UserDto> saveUSer(@RequestBody User user){
        return userService.searchUser(user);
    }

    @GetMapping("delete/{id}")
    public String deleteAuthorById(@PathVariable Long id) throws Exception {
        return userService.deleteById(id);
    }

}
