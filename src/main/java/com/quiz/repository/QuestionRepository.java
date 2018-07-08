package com.quiz.repository;

import com.quiz.dao.QuestionDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionDao, Long> {
}
