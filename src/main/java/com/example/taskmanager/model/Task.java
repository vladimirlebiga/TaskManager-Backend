package com.example.taskmanager.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
