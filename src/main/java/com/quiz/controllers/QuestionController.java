package com.quiz.controllers;

import com.quiz.dto.AnswerDto;
import com.quiz.dto.QuestionDto;
import com.quiz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question/add")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.CREATED)
    public void createQuestion(@RequestBody QuestionDto questionDto) {
        questionService.addQuestion(questionDto);
    }

    @PostMapping("/question/checkAnswer")
    @CrossOrigin(origins = "*")
    public String checkAnswer(@RequestBody List<AnswerDto> answerDto) {
        return questionService.checkAnswer(answerDto);
    }

    @GetMapping("/question/show")
    @CrossOrigin(origins = "*")
    public QuestionDto get() {
       return questionService.getQuestion();
    }

}
