package com.project.QuizApp.dao;
import com.project.QuizApp.question.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
