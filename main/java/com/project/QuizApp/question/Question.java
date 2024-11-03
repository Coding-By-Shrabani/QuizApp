package com.project.QuizApp.question;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slno;
    private String category;
    private String difficulty_level;
    private String questions;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answers;

}
