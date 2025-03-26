package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.userType.IUserType;
import com.sebastianvv.beltongym.persistence.entities.UserType;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/belton/userType")
public class UserTypeController {
    @Autowired
    private IUserType userTypeService;

    @GetMapping
    public List<UserType> getAll() {
        return userTypeService.findAll();
    }

    @GetMapping("/{id}")
    public UserType getById(@PathVariable UUID id) {
        return userTypeService.findById(id).get();
    }

    @PostMapping
    public UserType save(@RequestBody UserType userType) {
        return userTypeService.save(userType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userTypeService.deleteById(id);
    }
}