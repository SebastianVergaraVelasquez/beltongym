package com.sebastianvv.beltongym.domain.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.UserRepository;
import com.sebastianvv.beltongym.persistence.entities.User;

@Service
public class UserImpl implements IUser {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
       return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAllWithUserType();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
