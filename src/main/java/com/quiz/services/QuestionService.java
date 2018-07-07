package com.quiz.services;

import com.quiz.dto.AnswerDto;
import com.quiz.dto.QuestionDto;

import java.util.List;
import java.util.Set;

public interface QuestionService {

    void addQuestion(QuestionDto questionDto);

    String checkAnswer(List<AnswerDto> answerDtos);

    QuestionDto getQuestion();

}
