package com.example.hellomonolith.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String getHome() {
        return "index"; // Returns index.html from templates
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about"; // Returns about.html from templates
    }

    @GetMapping("/books")
    public String getBooks() {
        return "books"; // Returns books.html from templates
    }
}
