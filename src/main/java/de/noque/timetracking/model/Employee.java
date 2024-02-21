package de.noque.timetracking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false, unique = true)
    private String Email;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false)
    private String Role;

    @Column(nullable = false)
    private LocalDateTime TimeCreated;

    public Employee() {}

    public Employee(String name, String email, String password, String role) {
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.Role = role;
        this.TimeCreated = LocalDateTime.now();
    }

    //<editor-fold desc="Getter & Setter">
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public LocalDateTime getTimeCreated() {
        return TimeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        TimeCreated = timeCreated;
    }
    //</editor-fold>
}
