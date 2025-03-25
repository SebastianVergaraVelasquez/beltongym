package com.sebastianvv.beltongym.domain.services.membership;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sebastianvv.beltongym.persistence.entities.Membership;

public interface IMembership {
    Membership save(Membership membership);
    Optional<Membership> findById(UUID id);
    List<Membership> findAll();
    void deleteById(UUID id);
}
