package org.demo.todo.service.impl;

import org.demo.todo.domain.tasks;
import org.demo.todo.mapper.tasksMapper;
import org.demo.todo.service.tasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tasksServiceImpl implements tasksService {

    @Autowired
    private tasksMapper taskMapper;

    @Override
    public tasks selectTaskById(Long id) {
        return taskMapper.selectTaskById(id);
    }

    @Override
    public List<tasks> selectAllTasks() {
        return taskMapper.selectAllTasks();
    }

    @Override
    public int insertTask(tasks task) {
        return taskMapper.insertTask(task);
    }

    @Override
    public int updateTask(tasks task) {
        return taskMapper.updateTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskMapper.deleteTask(id);
    }

    @Override
    public List<tasks> findAllTasksByUserId(Long userId) {
        return taskMapper.findAllTasksByUserId(userId);
    }

}