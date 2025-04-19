package com.sebastianvv.beltongym.domain.services.membershipType;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.MembershipTypeRepository;
import com.sebastianvv.beltongym.persistence.entities.MembershipType;

@Service
public class MembershipTypeImpl implements IMembershipType{

    @Autowired
    private MembershipTypeRepository membershipTypeRepository;

    @Override
    public MembershipType save(MembershipType membershipType) {
        return membershipTypeRepository.save(membershipType);
    }

    @Override
    public Optional<MembershipType> findById(int id) {
        return membershipTypeRepository.findById(id);
    }

    @Override
    public List<MembershipType> findAll() {
        return (List<MembershipType>) membershipTypeRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
       membershipTypeRepository.deleteById(id);
    }

}
