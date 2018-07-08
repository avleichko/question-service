package com.quiz.repository;

import com.quiz.dao.UiConfigDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UiConfigRepository extends JpaRepository<UiConfigDao, Long> {
}
