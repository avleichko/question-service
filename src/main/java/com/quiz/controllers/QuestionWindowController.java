package com.quiz.controllers;


import com.quiz.services.QuestionWindow;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionWindowController {

    private final QuestionWindow service;

    public QuestionWindowController(QuestionWindow service) {
        this.service = service;
    }

    @PostMapping("/ui/config")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.CREATED)
    public void setConfig(@RequestParam String font, @RequestParam String color, @RequestParam String title, @RequestParam Integer width, @RequestParam Integer height) {
        service.buildConfig(font, color, title, width, height);
    }

    @GetMapping("/ui/config/get")
    @CrossOrigin(origins = "*")
    public String getConfig() {
       return service.getConfig();
    }

    @GetMapping("/ui/config/get/getTitle")
    @CrossOrigin(origins = "*")
    public String getTitle() {
        return service.getTitle();
    }
}
