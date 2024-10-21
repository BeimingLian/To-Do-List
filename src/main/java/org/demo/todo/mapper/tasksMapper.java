package org.demo.todo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.demo.todo.domain.tasks;

import java.util.List;
@Mapper
public interface tasksMapper {
    tasks selectTaskById(Long id);

    List<tasks> selectAllTasks();

    int insertTask(tasks task);

    int updateTask(tasks task);

    void deleteTask(Long id);
}
