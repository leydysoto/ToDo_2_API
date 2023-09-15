package com.leydy.todoapp.mapper;

import com.leydy.todoapp.persistencia.entity.Task;
import com.leydy.todoapp.persistencia.entity.TaskStatus;
import com.leydy.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOtoTask  implements IMapper<TaskInDTO,Task>{
    @Override
    public Task map(TaskInDTO in) {
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
