package com.quiz.services;

public interface QuestionWindow {
   void buildConfig(String font, String color, String title, Integer width, Integer height);
   String getConfig();
   String getTitle();
}
