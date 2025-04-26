package com.sebastianvv.beltongym.web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sebastianvv.beltongym.domain.services.user.IUser;

import com.sebastianvv.beltongym.persistence.entities.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/belton/user")
public class UserController {

    @Autowired
    private IUser userService;

   

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.findById(id).get();
        // cambiar para mejorar la validación
    }

    @PostMapping
    public User create(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteById(id);
    }
}
