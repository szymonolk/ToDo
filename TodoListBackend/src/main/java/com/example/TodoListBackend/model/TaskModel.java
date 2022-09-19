package com.example.TodoListBackend.model;

import lombok.NonNull;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100, min = 5)
    private String title;

    @NotBlank
    @Size(max = 15)
    @NotNull
    private String priority;


    @NotBlank
    @Size(max = 15)
    @NotNull
    private String status;

    public TaskModel() {
    }

    public TaskModel(Integer id, String title, String priority, String status) {
        this.id = id;
        this.title = title;
        this.priority = priority;

        this.status = status;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priority='" + priority + '\'' +

                ", status='" + status + '\'' +
                '}';
    }
}
