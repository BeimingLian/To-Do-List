package org.demo.todo.controller;

import jakarta.servlet.http.HttpSession;
import org.demo.todo.domain.users;
import org.demo.todo.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class usersController {

    @Autowired
    private usersService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // 返回 login.html
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // 返回 register.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        users user = userService.findUserByNameAndPassword(username, password);
        if (user != null) {
            session.setAttribute("userId", user.getId()); // 存入 session
            return "redirect:/task";
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "login";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        if (userService.findUserByName(username) != null) {
            model.addAttribute("error", "用户名已存在");
            return "register";
        }
        users newUser = new users();
        newUser.setUserName(username);
        newUser.setPassword(password);
        userService.insertUser(newUser);

        // 自动登录并存入 session
        session.setAttribute("userId", newUser.getId());
        return "redirect:/task";
    }
}
