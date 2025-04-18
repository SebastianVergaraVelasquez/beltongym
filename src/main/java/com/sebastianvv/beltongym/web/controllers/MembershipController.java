package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.membership.IMembership;
import com.sebastianvv.beltongym.persistence.entities.Membership;

import java.util.List;

@RestController
@RequestMapping("/belton/membership")
public class MembershipController {
    @Autowired
    private IMembership membershipService;

    @GetMapping
    public List<Membership> getAll() {
        return membershipService.findAll();
    }

    @GetMapping("/{id}")
    public Membership getById(@PathVariable int id) {
        return membershipService.findById(id).get();
    }

    @PostMapping
    public Membership save(@RequestBody Membership membership) {
        return membershipService.save(membership);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        membershipService.deleteById(id);
    }
}
