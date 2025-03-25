package com.sebastianvv.beltongym.domain.services.userType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sebastianvv.beltongym.persistence.entities.UserType;

public interface IUserType {
    UserType save(UserType userType);
    Optional<UserType> findById(UUID id);
    List<UserType> findAll();
    void deleteById(UUID id);
}
