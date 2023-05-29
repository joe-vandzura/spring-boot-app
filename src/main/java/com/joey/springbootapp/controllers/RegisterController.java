package com.joey.springbootapp.controllers;

import com.joey.springbootapp.models.User;
import com.joey.springbootapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserRepository userDao;

    public RegisterController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute(name = "user") User user) {
        userDao.save(user);
        return "redirect:/";
    }

}
