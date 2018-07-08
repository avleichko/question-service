package com.quiz.repository;

import com.quiz.dao.AnswerDao;
import com.quiz.dao.QuestionDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerDao, Long> {
}
