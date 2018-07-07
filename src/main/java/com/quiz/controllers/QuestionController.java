package com.quiz.controllers;

import com.quiz.dto.AnswerDto;
import com.quiz.dto.QuestionDto;
import com.quiz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createQuestion(@RequestBody QuestionDto questionDto) {
        questionService.addQuestion(questionDto);
    }

    @PostMapping("/question/checkAnswer")
    public String checkAnswer(@RequestBody List<AnswerDto> answerDto) {
        String s = questionService.checkAnswer(answerDto);
        return s;
    }


    @PostMapping("/question/show")
    public QuestionDto get() {
       return questionService.getQuestion();
    }

}
