package com.leydy.todoapp.mapper;

import com.leydy.todoapp.model.Task;
import com.leydy.todoapp.model.TaskStatus;
import com.leydy.todoapp.model.dto.TaskRequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskRequestDTOtoTask implements IMapper<TaskRequestDTO, Task>{
    @Override
    public Task map(TaskRequestDTO in) {
        Task task=new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDaate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
