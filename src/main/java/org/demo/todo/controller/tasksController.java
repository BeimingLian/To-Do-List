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
        return "redirect:/task";
    }

    @PostMapping("/update")
    public String updateTask(@RequestParam("taskId") Long taskId,
                             @RequestParam("taskName") String taskName,
                             @RequestParam("taskDescription") String taskDescription,
                             @RequestParam("dueDate") String dueDate,
                             @RequestParam("status") String status) {
        tasks task = taskService.selectTaskById(taskId);
        if (task != null) {
            task.setTaskName(taskName);
            task.setTaskDescription(taskDescription);
            task.setDueDate(dueDate);
            task.setStatus(status);
            taskService.updateTask(task);
        }
        return "redirect:/task";
    }


    @PostMapping("/delete")
    public String deleteTask(@RequestParam("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/task";
    }

}
