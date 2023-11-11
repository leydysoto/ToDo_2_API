package com.leydy.todoapp.service;

import com.leydy.todoapp.exception.ToDoExcepcions;
import com.leydy.todoapp.mapper.TaskRequestDTOtoTask;
import com.leydy.todoapp.model.Task;
import com.leydy.todoapp.model.TaskStatus;
import com.leydy.todoapp.model.dto.TaskRequestDTO;
import com.leydy.todoapp.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public void taskAsFinished(Long id){
        Optional<Task> toptionalTask =repository.findById(id);
        if(toptionalTask.isEmpty()){
            throw new ToDoExcepcions("task not found", HttpStatus.NOT_FOUND);

        }
        repository.markTaskAsFinished(id);
    }
    public void deleteById(Long id){
        Optional<Task>optionalTask=repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExcepcions("task not found",HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }


}
