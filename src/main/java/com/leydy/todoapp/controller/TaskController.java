package com.leydy.todoapp.controller;

import com.leydy.todoapp.model.Task;
import com.leydy.todoapp.model.TaskStatus;
import com.leydy.todoapp.model.dto.TaskRequestDTO;
import com.leydy.todoapp.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody TaskRequestDTO taskRequestDTO){
        return taskService.createTask(taskRequestDTO);
    }

    @GetMapping
    public List<Task> findAll(){
        return taskService.findAll();
    }
    @GetMapping("/taskStatus/{status}")
    public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status){
        return  taskService.findAllByTaskStatus(status);
    }



}
