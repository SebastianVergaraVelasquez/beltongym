package com.sebastianvv.beltongym.domain.services.attendance;

import java.util.List;
import java.util.Optional;

import com.sebastianvv.beltongym.persistence.entities.Attendance;

public interface IAttendance {
    Attendance save(Attendance attendance);
    Optional<Attendance> findById(int id);
    List<Attendance> findAll();
    void deleteById(int id);
}
