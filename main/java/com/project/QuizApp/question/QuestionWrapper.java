package com.project.QuizApp.question;

import lombok.Data;

@Data
public class QuestionWrapper {
    private int slno;
    private String questions;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(int slno, String questions, String option1, String option2, String option3, String option4) {
        this.slno = slno;
        this.questions = questions;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
