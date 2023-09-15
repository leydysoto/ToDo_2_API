package com.leydy.todoapp.service;

import com.leydy.todoapp.exception.ToDoExcepcions;
import com.leydy.todoapp.mapper.TaskInDTOtoTask;
import com.leydy.todoapp.persistencia.entity.Task;
import com.leydy.todoapp.persistencia.entity.TaskStatus;
import com.leydy.todoapp.persistencia.repository.TaskRepository;
import com.leydy.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskInDTOtoTask mapper;

    public TaskService(TaskRepository taskRepository, TaskInDTOtoTask mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }
    public Task createTask(TaskInDTO taskInDTO ){
        Task task=mapper.map(taskInDTO);
        return this.taskRepository.save(task);
    }
    public List<Task>findAll(){
        return this.taskRepository.findAll();
    }
    //obtener una lista de las tareas de tal estado
    public List<Task>findAllByTaskStatus(TaskStatus status){
        return this.taskRepository.findAllByTaskStatus(status);
    }

    //obtener la task segun el id puede esta o no
    public Optional<Task> getTask(Long id) {
        Optional<Task>optionalTask=this.taskRepository.findById(id);
        return optionalTask;
    }


    @Transactional
    public void updateTasAsFinished(Long id){
        Optional<Task>taskFind=getTask(id);
        if(taskFind.isEmpty()){
            throw new ToDoExcepcions("task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.markTaskAsFinished(id);
    }
    public void deleteTask(Long id){
        Optional<Task>taskFind=getTask(id);
        if(taskFind.isEmpty()){
            throw new ToDoExcepcions("task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }

}
