package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.sebastianvv.beltongym.domain.services.membership.IMembership;
import com.sebastianvv.beltongym.domain.services.user.IUser;
import com.sebastianvv.beltongym.persistence.entities.Membership;
import com.sebastianvv.beltongym.persistence.entities.User;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/belton/membership")
public class MembershipController {
    @Autowired
    private IMembership membershipService;
    @Autowired
    private IUser userService;

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
        Optional<User> userOpt = userService.findByDocument(membership.getUser().getDocument());

        if (userOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Usuario no encontrado con el documento: " + membership.getUser().getDocument());
        }

        Membership membership2 = new Membership();
        membership2.setUser(userOpt.get());
        membership2.setMembershipType(membership.getMembershipType());
        membership2.setStartDate(membership.getStartDate());
        membership2.setEndDate(membership.getEndDate());
        membership2.setComment(membership.getComment());

        return membershipService.save(membership2);
    }

    @PutMapping("/{id}")
    public Membership put(@PathVariable int id, @RequestBody Membership updatedMembership) {
        Optional<Membership> existingOpt = membershipService.findById(id);
    if (existingOpt.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Membresía no encontrada con id: " + id);
    }

    Optional<User> userOpt = userService.findByDocument(updatedMembership.getUser().getDocument());
    if (userOpt.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado con el documento: " + updatedMembership.getUser().getDocument());
    }

    Membership membership = existingOpt.get();
    membership.setUser(userOpt.get());
    membership.setMembershipType(updatedMembership.getMembershipType());
    membership.setStartDate(updatedMembership.getStartDate());
    membership.setEndDate(updatedMembership.getEndDate());
    membership.setComment(updatedMembership.getComment());

    return membershipService.save(membership);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        membershipService.deleteById(id);
    }
}
