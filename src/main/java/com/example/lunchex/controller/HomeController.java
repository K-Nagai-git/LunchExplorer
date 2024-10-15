package com.example.lunchex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/lunchexplorer")
    public String home() {
        return "index";
    }
}