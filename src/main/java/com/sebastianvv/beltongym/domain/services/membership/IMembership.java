package com.sebastianvv.beltongym.domain.services.membership;

import java.util.List;
import java.util.Optional;

import com.sebastianvv.beltongym.persistence.entities.Membership;

public interface IMembership {
    Membership save(Membership membership);
    Optional<Membership> findById(int id);
    List<Membership> findAll();
    void deleteById(int id);
}
