package com.practice.todoapp.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Task extends BaseEntity{

    String title;
    String description;
    Boolean status;
    LocalDate deadline;
    LocalDate completionDate;

    @ManyToOne
    @JoinColumn
    private User user;

    public Task() {
    }

    public Task(LocalDate createdDate, LocalDate updatedDate, int id, String title, String description, Boolean status, LocalDate deadline, LocalDate completionDate) {
        super(createdDate, updatedDate);
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
        this.completionDate = completionDate;
    }

    public Task(Integer id, LocalDate createdDate, LocalDate updatedDate, int id1, String title, String description, Boolean status, LocalDate deadline, LocalDate completionDate) {
        super(id, createdDate, updatedDate);
        this.id = id1;
        this.title = title;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
        this.completionDate = completionDate;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", deadline=" + deadline +
                ", completionDate=" + completionDate +
                ", id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

}
