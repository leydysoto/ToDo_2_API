package com.leydy.todoapp.controller;

import com.leydy.todoapp.model.Task;
import com.leydy.todoapp.model.dto.TaskRequestDTO;
import com.leydy.todoapp.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody TaskRequestDTO taskRequestDTO){
        return taskService.createTask(taskRequestDTO);
    }



}
