package com.leydy.todoapp.model.dto;



import com.leydy.todoapp.model.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskRequestDTO {

    private String title;
    private String description;
    private  LocalDateTime eta;
}
