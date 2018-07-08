package com.quiz.services;

import org.springframework.web.bind.annotation.RequestParam;

public interface QuestionWindow {
   void buildConfig(String font, String color, String title, Integer width, Integer height);
   String getConfig();
}
