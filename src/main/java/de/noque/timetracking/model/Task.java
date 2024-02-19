package de.noque.timetracking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long EmployeeId;

    private String Task;

    private LocalDateTime TimeFrom;

    private LocalDateTime TimeTo;

    private LocalDateTime TimeCreated;

    public Task() {}

    public Task(Long employeeId, String task, LocalDateTime timeFrom, LocalDateTime timeTo) {
        this.EmployeeId = employeeId;
        this.Task = task;
        this.TimeFrom = timeFrom;
        this.TimeTo = timeTo;
        this.TimeCreated = LocalDateTime.now();
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

    public LocalDateTime getTimeCreated() {
        return TimeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        TimeCreated = timeCreated;
    }
    //</editor-fold>
}
