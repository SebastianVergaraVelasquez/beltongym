package com.sebastianvv.beltongym.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance,Integer>{
    @Query("SELECT a FROM Attendance a JOIN FETCH a.user")
    List<Attendance> findAllWithUser();
}
