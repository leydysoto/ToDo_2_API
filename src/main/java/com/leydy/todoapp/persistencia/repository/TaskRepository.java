package com.leydy.todoapp.persistencia.repository;

import com.leydy.todoapp.persistencia.entity.Task;
import com.leydy.todoapp.persistencia.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long>{
    //obtener una lista de las tareas de tal estado
    public List<Task> findAllByTaskStatus(TaskStatus status);

    //poner si se finalizo  tarea

    @Modifying
    @Query(value="UPDATE TASK SET FINISHED=true WHERE ID=:id",nativeQuery = true)
    public void markTaskAsFinished(@Param("id")Long id);
}
