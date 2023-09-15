package com.leydy.todoapp.controller;

import com.leydy.todoapp.persistencia.entity.Task;
import com.leydy.todoapp.persistencia.entity.TaskStatus;
import com.leydy.todoapp.service.TaskService;
import com.leydy.todoapp.service.dto.TaskInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {

        this.taskService = taskService;
    }
    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){

        return this.taskService.createTask(taskInDTO);
    }
    @GetMapping
    public List<Task> findAll() {
        return this.taskService.findAll();
    }
    //obtener una lista de las tareas de tal estado
    @GetMapping("/status/{status}")
    public List<Task> findAllbyStatus(@PathVariable("status") TaskStatus status) {
        return this.taskService.findAllByTaskStatus(status);
    }
    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void>markAsfinished(@PathVariable("id") Long id){
        this.taskService.updateTasAsFinished(id);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("/delete_task/{id}")
    public ResponseEntity<Void>deleteTask(@PathVariable("id") Long id){
        this.taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }



}
