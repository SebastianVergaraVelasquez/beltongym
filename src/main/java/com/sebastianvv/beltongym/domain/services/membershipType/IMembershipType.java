package com.sebastianvv.beltongym.domain.services.membershipType;

import java.util.List;
import java.util.Optional;

import com.sebastianvv.beltongym.persistence.entities.MembershipType;

public interface IMembershipType {
    MembershipType save(MembershipType membershipType);
    Optional<MembershipType> findById(int id);
    List<MembershipType> findAll();
    void deleteById(int id);
}
