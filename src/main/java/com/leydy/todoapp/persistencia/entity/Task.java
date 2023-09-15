package com.leydy.todoapp.persistencia.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDaate;
    private  LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
