package com.quiz.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AnswerDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ANSWER_ID")
    private Long id;

    private String answer;
    private boolean isCorrect = false;

    @ManyToOne
    @JoinColumn(name="QUESTION_ID")
    private QuestionDao questionDao;
}
