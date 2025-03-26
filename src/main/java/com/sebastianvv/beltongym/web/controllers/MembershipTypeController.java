package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.membershipType.IMembershipType;
import com.sebastianvv.beltongym.persistence.entities.MembershipType;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/belton/membershipType")
public class MembershipTypeController {
    @Autowired
    private IMembershipType membershipTypeService;

    @GetMapping
    public List<MembershipType> getAll() {
        return membershipTypeService.findAll();
    }

    @GetMapping("/{id}")
    public MembershipType getById(@PathVariable UUID id) {
        return membershipTypeService.findById(id).get();
    }

    @PostMapping
    public MembershipType save(@RequestBody MembershipType membershipType) {
        return membershipTypeService.save(membershipType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        membershipTypeService.deleteById(id);
    }
}
