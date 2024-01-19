package com.api.crud.controllers;

import com.api.crud.models.User;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return this.userService.getUserById(id);
    }

    @PutMapping(path = "/{id}")
    public User updateUserById(@RequestBody User request,@PathVariable("id") Long id){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = {"/{id}"})
    public String deleteUserById(@PathVariable("id") Long id){
        boolean correct = this.userService.deleteUser(id);
        if(correct){
            return "User with id " + id + "deleted correctly";
        }else{
            return "User was not found";
        }
    }
}
