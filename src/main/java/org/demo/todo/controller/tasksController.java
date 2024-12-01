package org.demo.todo.controller;

import jakarta.servlet.http.HttpSession;
import org.demo.todo.domain.tasks;
import org.demo.todo.service.tasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/task")
public class tasksController {

    @Autowired
    private tasksService taskService;

    @GetMapping
    public String listTasks(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        System.out.println("User ID: " + userId);
        if (userId == null) {
            return "redirect:/login";
        }
        List<tasks> tasks = taskService.findAllTasksByUserId(userId);
        System.out.println("Tasks: " + tasks);
        model.addAttribute("tasks", tasks);
        model.addAttribute("userId", userId);
        return "tasks";
    }


    @PostMapping("/add")
    public String addTask(@RequestParam Long userId, @RequestParam String taskName,
                          @RequestParam String taskDescription, @RequestParam String dueDate) {
        tasks newTask = new tasks();
        newTask.setTaskName(taskName);
        newTask.setTaskDescription(taskDescription);
        newTask.setDueDate(dueDate);
        newTask.setUserId(userId);
        taskService.insertTask(newTask);
        return "redirect:/task/list?userId=" + userId;
    }

    @PostMapping("/update")
    public String updateTask(@RequestParam Long taskId, @RequestParam String taskName,
                             @RequestParam String taskDescription, @RequestParam String dueDate) {
        tasks task = taskService.selectTaskById(taskId);
        task.setTaskName(taskName);
        task.setTaskDescription(taskDescription);
        task.setDueDate(dueDate);
        taskService.updateTask(task);
        return "redirect:/task/list?userId=" + task.getUserId();
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam Long taskId, @RequestParam Long userId) {
        taskService.deleteTask(taskId);
        return "redirect:/task/list?userId=" + userId;
    }
}
