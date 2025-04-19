package com.sebastianvv.beltongym.domain.services.user;

import java.util.List;
import java.util.Optional;

import com.sebastianvv.beltongym.persistence.entities.User;

public interface IUser {
    User save(User user);
    //update por ahora no, creo funciona la misma de save
    Optional<User> findById(int id);
    List<User> findAll();
    void deleteById(int id);
}
