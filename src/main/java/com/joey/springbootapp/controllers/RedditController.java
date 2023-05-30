package com.joey.springbootapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URL;

@Controller
@RequestMapping("/reddit")
public class RedditController {

    private final String redditURL = "https://oauth.reddit.com";

    @GetMapping
    public String returnRedditProfileInfo(Model model) {
        try {
            URL url = new URL(redditURL);
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        model.addAttribute("reddit", reddit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
