package org.demo.todo.service;

import org.demo.todo.domain.tasks;

import java.util.List;

public interface tasksService {
    tasks selectTaskById(Long id);
    List<tasks> selectAllTasks();
    int insertTask(tasks task);
    int updateTask(tasks task);
    void deleteTask(Long id);
}
