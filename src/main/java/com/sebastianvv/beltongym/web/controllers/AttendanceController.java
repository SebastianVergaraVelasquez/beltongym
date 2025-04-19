package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.attendance.IAttendance;
import com.sebastianvv.beltongym.persistence.entities.Attendance;

import java.util.List;

@RestController
@RequestMapping("/belton/attendance")
public class AttendanceController {
    @Autowired
    private IAttendance attendanceService;

    @GetMapping
    public List<Attendance> getAll() {
        return attendanceService.findAll();
    }

    @GetMapping("/{id}")
    public Attendance getById(@PathVariable int id) {
        return attendanceService.findById(id).get();
    }

    @PostMapping
    public Attendance save(@RequestBody Attendance attendance) {
        return attendanceService.save(attendance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        attendanceService.deleteById(id);
    }
}
