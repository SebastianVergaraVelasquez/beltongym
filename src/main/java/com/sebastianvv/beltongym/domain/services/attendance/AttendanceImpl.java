package com.sebastianvv.beltongym.domain.services.attendance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.AttendanceRepository;
import com.sebastianvv.beltongym.persistence.entities.Attendance;

@Service
public class AttendanceImpl implements IAttendance {

    @Autowired
    private AttendanceRepository attendanceRepository;
    
    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Optional<Attendance> findById(int id) {
       return attendanceRepository.findById(id);
    }

    @Override
    public List<Attendance> findAll() {
        return (List<Attendance>) attendanceRepository.findAllWithUser();
    }

    @Override
    public void deleteById(int id) {
        attendanceRepository.deleteById(id);
    }
}
