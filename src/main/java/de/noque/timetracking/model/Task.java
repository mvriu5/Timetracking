package de.noque.timetracking.model;

import jakarta.persistence.*;
import jdk.jfr.Timespan;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private Long EmployeeId;

    @Column(nullable = false)
    private String Task;

    @Column(nullable = false)
    private LocalDateTime TimeFrom;

    @Column(nullable = false)
    private LocalDateTime TimeTo;

    @Column(nullable = false)
    private int Timespan;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime TimeCreated;

    public Task() {}

    public Task(Long employeeId, String task, LocalDateTime timeFrom, LocalDateTime timeTo) {
        this.EmployeeId = employeeId;
        this.Task = task;
        this.TimeFrom = timeFrom;
        this.TimeTo = timeTo;
        this.Timespan = Duration.between(timeFrom, timeTo).toMinutesPart();
    }

    //<editor-fold desc="Getter & Setter">
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(Long employeeId) {
        EmployeeId = employeeId;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public LocalDateTime getTimeFrom() {
        return TimeFrom;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        TimeFrom = timeFrom;
    }

    public LocalDateTime getTimeTo() {
        return TimeTo;
    }

    public void setTimeTo(LocalDateTime timeTo) {
        TimeTo = timeTo;
    }

    public int getTimespan() {
        return Timespan;
    }

    public void setTimespan(int timespan) {
        Timespan = timespan;
    }

    public LocalDateTime getTimeCreated() {
        return TimeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        TimeCreated = timeCreated;
    }
    //</editor-fold>
}
