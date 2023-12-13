package com.example.radikan.gym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "index";
    }
}
