package com.quiz.services;

import com.quiz.dao.AnswerDao;
import com.quiz.dao.QuestionDao;
import com.quiz.dto.AnswerDto;
import com.quiz.dto.QuestionDto;
import com.quiz.exceptions.NotValidPayloadException;
import com.quiz.repository.AnswerRepository;
import com.quiz.repository.QuestionRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private QuestionDto storage;

    private final QuestionRepository repository;
    private final AnswerRepository answerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public QuestionServiceImpl(QuestionRepository repository, ModelMapper modelMapper, AnswerRepository answerRepository) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.answerRepository = answerRepository;
    }

    @Override
    public void addQuestion(QuestionDto questionDto) {
        answerRepository.deleteAll();
        repository.deleteAll();
        QuestionDao dao = new QuestionDao();

        dao.setQuestionText(questionDto.getQuestionText());

        List<AnswerDto> incomeDtos = questionDto.getAnswerDtos();


        incomeDtos.stream().filter(AnswerDto::isCorrect).findAny().orElseThrow(() -> new NotValidPayloadException("Question needs to have 1 valid answer"));

        java.lang.reflect.Type targetListType = new TypeToken<List<AnswerDao>>() {
        }.getType();

        List<AnswerDao> answerDaos = modelMapper.map(incomeDtos, targetListType);

        dao.setAnswerDaos(answerDaos);

        repository.save(dao);

    }

    @Override
    public String checkAnswer(List<AnswerDto> userAnswerDtos) {
        List<QuestionDao> question = repository.findAll();
        List<AnswerDao> answers = answerRepository.findAll();

        if (question.isEmpty() || answers.isEmpty()) {
            throw new SecurityException("storage is empty");
        }


        java.lang.reflect.Type targetListType = new TypeToken<List<AnswerDto>>() {
        }.getType();

        List<AnswerDto> storageAnswerDtos = modelMapper.map(answers, targetListType);

        List<AnswerDto> collect = storageAnswerDtos.stream().filter(AnswerDto::isCorrect).collect(Collectors.toList());
        List<String> validAnswersText = collect.stream().map(AnswerDto::getAnswer).collect(Collectors.toList());
        if (!collect.containsAll(userAnswerDtos)) {
            return ("Valid answers are :" + validAnswersText.toString());
        }
        return "correct answer";
    }

    @Override
    public QuestionDto getQuestion() {
        List<QuestionDao> question = repository.findAll();
        List<AnswerDao> answers = answerRepository.findAll();
        if (question.isEmpty() || answers.isEmpty()) {
            throw new SecurityException("storage is empty");
        }

        QuestionDao questionDao = question.stream().findFirst().get();
        java.lang.reflect.Type targetListType = new TypeToken<List<AnswerDto>>() {
        }.getType();

        List<AnswerDto> storageAnswerDtos = modelMapper.map(answers, targetListType);


        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionText(questionDao.getQuestionText());
        questionDto.setAnswerDtos(storageAnswerDtos);
        questionDto.getAnswerDtos().forEach(answerDto -> answerDto.setCorrect(false));
        return questionDto;
    }


}
