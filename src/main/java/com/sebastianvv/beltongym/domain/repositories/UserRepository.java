package com.sebastianvv.beltongym.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u JOIN FETCH u.userType")
    List<User> findAllWithUserType();
    Optional<User> findByDocument(int document);
    User findByEmail(String email);
}
