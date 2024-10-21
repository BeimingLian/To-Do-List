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
    private tasksMapper tasksMapper;

    @Override
    public tasks selectTaskById(Long id) {
        return tasksMapper.selectTaskById(id);
    }

    @Override
    public List<tasks> selectAllTasks() {
        return tasksMapper.selectAllTasks();
    }

    @Override
    public int insertTask(tasks task) {
        return tasksMapper.insertTask(task);
    }

    @Override
    public int updateTask(tasks task) {
        return tasksMapper.updateTask(task);
    }

    @Override
    public void deleteTask(Long id) {
        tasksMapper.deleteTask(id);
    }
}