package com.practice.todoapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Role extends BaseEntity{
    String title;

    public Role() {
    }

    public Role(LocalDate createdDate, LocalDate updatedDate, String title) {
        super(createdDate, updatedDate);
        this.title = title;
    }

    public Role(Integer id, LocalDate createdDate, LocalDate updatedDate, String title) {
        super(id, createdDate, updatedDate);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Role{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    @OneToMany(mappedBy = "role")
    List<User> users;
}
