package com.quiz.services;

import com.quiz.dto.AnswerDto;
import com.quiz.dto.QuestionDto;
import com.quiz.exceptions.NotValidAnswerException;
import com.quiz.exceptions.NotValidPayloadException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDto storage;

    @Override
    public void addQuestion(QuestionDto questionDto) {
        storage = questionDto;
        List<AnswerDto> answerDtos = storage.getAnswerDtos();
        answerDtos.stream().filter(AnswerDto::isCorrect).findAny().orElseThrow(() -> new NotValidPayloadException("Question needs to have 1 valid answer"));
        storage = questionDto;
    }

    @Override
    public String checkAnswer(List<AnswerDto> userAnswerDtos) {
        List<AnswerDto> storageAnswerDtos = storage.getAnswerDtos();
        List<AnswerDto> collect = storageAnswerDtos.stream().filter(AnswerDto::isCorrect).collect(Collectors.toList());
        List<String> validAnswersText = collect.stream().map(AnswerDto::getAnswer).collect(Collectors.toList());
        if (!userAnswerDtos.containsAll(collect)) {
            return ("Valid answers are :" + validAnswersText.toString());
        }
        return "correct answer";
    }

    @Override
    public QuestionDto getQuestion() {
        QuestionDto questionDto = storage;
        questionDto.getAnswerDtos().forEach(answerDto -> answerDto.setCorrect(false));
        return questionDto;
    }


}
