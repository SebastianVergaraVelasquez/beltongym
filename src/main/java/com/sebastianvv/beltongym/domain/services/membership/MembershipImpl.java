package com.sebastianvv.beltongym.domain.services.membership;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.MembershipRepository;
import com.sebastianvv.beltongym.persistence.entities.Membership;

@Service
public class MembershipImpl implements IMembership{

    @Autowired
    private MembershipRepository membershipRepository;
    
    @Override
    public Membership save(Membership membership) {
        return membershipRepository.save(membership);
    }

    @Override
    public Optional<Membership> findById(int id) {
        return membershipRepository.findById(id);
    }

    @Override
    public List<Membership> findAll() {
        return (List<Membership>) membershipRepository.findAllWithMembershipTypeAndUser();
    }

    @Override
    public void deleteById(int id) {
       membershipRepository.deleteById(id);
    }

}
