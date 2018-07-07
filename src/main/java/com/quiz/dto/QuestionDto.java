package com.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class QuestionDto {
    private String questionText;
    List<AnswerDto> answerDtos;
}
