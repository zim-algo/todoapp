package com.practice.todoapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class User extends BaseEntity{

    String firstName;
    String lastName;
    String password;
    String email;
    Boolean status;

    public User() {
    }

    public User(LocalDate createdDate, LocalDate updatedDate, String firstName, String lastName, String password, String email, Boolean status) {
        super(createdDate, updatedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public User(Integer id, LocalDate createdDate, LocalDate updatedDate, String firstName, String lastName, String password, String email, Boolean status) {
        super(id, createdDate, updatedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    @ManyToOne
    @JoinColumn
    private Role role;

    @OneToMany(mappedBy = "user")
    List<Task> tasks;
}
