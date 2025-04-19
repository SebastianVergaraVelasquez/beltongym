package com.sebastianvv.beltongym.domain.services.userType;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.UserTypeRepository;
import com.sebastianvv.beltongym.persistence.entities.UserType;

@Service
public class UserTypeImpl implements IUserType{

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public UserType save(UserType userType) {
       return userTypeRepository.save(userType);
    }

    @Override
    public Optional<UserType> findById(int id) {
       return userTypeRepository.findById(id);
    }

    @Override
    public List<UserType> findAll() {
        return (List<UserType>) userTypeRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        userTypeRepository.deleteById(id);
    }

}
