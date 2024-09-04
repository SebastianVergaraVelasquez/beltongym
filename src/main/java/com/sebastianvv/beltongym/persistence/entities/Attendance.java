package com.sebastianvv.beltongym.persistence.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @ManyToOne
    private User user;

    @Column(name = "entry_time", nullable = false)
    private LocalDateTime entryTime; 

    @Column(name = "exit_time")
    private LocalDateTime exitTime;

    private String comment;

    public Attendance() {
    }

    public Attendance(UUID id, User user, LocalDateTime entryTime, LocalDateTime exitTime, String comment) {
        this.id = id;
        this.user = user;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.comment = comment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    

}
