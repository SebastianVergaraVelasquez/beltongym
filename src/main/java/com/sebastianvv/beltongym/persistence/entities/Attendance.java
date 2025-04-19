package com.sebastianvv.beltongym.persistence.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @Column(name = "entry_time", nullable = false)
    //posible formato para agregar y deserializar, depende de cómo lo envíe desde el front
    private LocalDateTime entryTime; 

    @Column(name = "exit_time")
    //posible formato para agregar y deserializar, depende de cómo lo envíe desde el front
    private LocalDateTime exitTime;

    private String comment;

    public Attendance() {
    }

    public Attendance(int id, User user, LocalDateTime entryTime, LocalDateTime exitTime, String comment) {
        this.id = id;
        this.user = user;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
