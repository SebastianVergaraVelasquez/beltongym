package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.attendance.IAttendance;
import com.sebastianvv.beltongym.persistence.entities.Attendance;
import com.sebastianvv.beltongym.persistence.entities.User;

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

    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable int id, @RequestBody Attendance attendanceUpdated) {
        Attendance existingAttendance = attendanceService.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));

        existingAttendance.setComment(attendanceUpdated.getComment());
        existingAttendance.setEntryTime(attendanceUpdated.getEntryTime());
        existingAttendance.setExitTime(attendanceUpdated.getExitTime());

        // Asegurarse de que el objeto User venga con su ID
        if (attendanceUpdated.getUser() != null) {
            User user = new User();
            user.setId(attendanceUpdated.getUser().getId());
            existingAttendance.setUser(user);
        }

        return attendanceService.save(existingAttendance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        attendanceService.deleteById(id);
    }
}
