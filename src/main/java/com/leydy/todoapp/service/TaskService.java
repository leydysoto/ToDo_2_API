package com.leydy.todoapp.service;

import com.leydy.todoapp.mapper.TaskRequestDTOtoTask;
import com.leydy.todoapp.model.Task;
import com.leydy.todoapp.model.TaskStatus;
import com.leydy.todoapp.model.dto.TaskRequestDTO;
import com.leydy.todoapp.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskRequestDTOtoTask mapper;

    public Task createTask(TaskRequestDTO taskRequestDTO){
        Task task=mapper.map(taskRequestDTO);
        return repository.save(task);
    }
    public List<Task> findAll(){
        return repository.findAll();

    }
    public List<Task> findAllByTaskStatus(TaskStatus taskStatus){
        return repository.findAllByTaskStatus(taskStatus);

    }


}
