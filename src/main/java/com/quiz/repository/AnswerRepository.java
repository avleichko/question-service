package com.quiz.repository;

import com.quiz.dao.AnswerDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerDao, Long> {
}
