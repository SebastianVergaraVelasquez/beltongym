package com.sebastianvv.beltongym.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.Membership;

public interface MembershipRepository extends CrudRepository<Membership,Integer> {
    @Query("SELECT m FROM Membership m JOIN FETCH m.membershipType JOIN FETCH m.user")
    List<Membership> findAllWithMembershipTypeAndUser();
}
