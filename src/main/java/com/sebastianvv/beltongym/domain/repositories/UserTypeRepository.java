package com.sebastianvv.beltongym.domain.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, UUID>{

}
