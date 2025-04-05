package com.sebastianvv.beltongym.web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sebastianvv.beltongym.domain.services.user.IUser;

import com.sebastianvv.beltongym.persistence.entities.User;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/belton/user")
public class UserController {

    @Autowired
    private IUser userService;

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }
    
    @GetMapping("/{id}")
    public User getById(@PathVariable UUID id) {
        return userService.findById(id).get();
        //cambiar para mejorar la validación
    }
    
    @PostMapping("path")
    public User postMethodName(@RequestBody User user) {
        return userService.save(user);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        userService.deleteById(id);
    }
}
