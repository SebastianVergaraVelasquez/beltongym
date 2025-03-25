package com.sebastianvv.beltongym.domain.services.attendance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.sebastianvv.beltongym.domain.repositories.AttendanceRepository;
import com.sebastianvv.beltongym.persistence.entities.Attendance;

public class AttendanceImpl implements IAttendance {

    @Autowired
    private AttendanceRepository attendanceRepository;
    
    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Optional<Attendance> findById(UUID id) {
       return attendanceRepository.findById(id);
    }

    @Override
    public List<Attendance> findAll() {
        return (List<Attendance>) attendanceRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        attendanceRepository.deleteById(id);
    }
}
