package com.leydy.todoapp.service.dto;

import com.leydy.todoapp.persistencia.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskOutDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDaate;
    private  LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
