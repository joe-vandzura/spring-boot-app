package com.joey.springbootapp.controllers;

import com.joey.springbootapp.models.User;
import com.joey.springbootapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserRepository userDao;

    public RegisterController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String showRegisterPage() {
        return "users/register";
    }

    @PostMapping
    public String createNewUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(username);
        userDao.save(newUser);
        return "redirect:/";
    }

}
