package com.example.ajax.fronend.entity;

import java.sql.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String description;
    String status;
    Date start;
    Date end;
    @Column(nullable = true)
    Integer actual;
    @Column(nullable = true)
    Integer expected;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getStart() {
        return start;
    }
    public void setStart(Date start) {
        this.start = start;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }
    public Integer getActual() {
        return actual;
    }
    public void setActual(int actual) {
        this.actual = actual;
    }
    public Integer getExpected() {
        return expected;
    }
    public void setExpected(int expected) {
        this.expected = expected;
    }
    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
                + ", start=" + start + ", end=" + end + ", actual=" + actual + ", expected=" + expected + "]";
    }
    

}
