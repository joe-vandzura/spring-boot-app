package com.joey.springbootapp.controllers;

import com.joey.springbootapp.models.User;
import com.joey.springbootapp.repositories.UserRepository;
import com.joey.springbootapp.utils.Reddit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final UserRepository userDao;

    public HomeController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        Reddit reddit = new Reddit();
        String redditAccessToken = reddit.getAccessToken();
        List<User> allUsers = userDao.findAll();
        model.addAttribute("users", allUsers);
        model.addAttribute("redditToken", redditAccessToken);
        return "index";
    }
}
