package com.quiz.dao;

import com.quiz.dto.AnswerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "QUESTION_ID")
    private Long id;
    private String questionText;

    @OneToMany(mappedBy = "questionDao", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<AnswerDao> answerDaos = new ArrayList<>();
}
