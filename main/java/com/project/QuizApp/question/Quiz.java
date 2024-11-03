package com.project.QuizApp.question;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity   // it is used to mark a class as a JPA entity
@Data     //Part of Lombok Library , which reduces boilerplate code
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
   private String title;
   @ManyToMany
   private List<Question> questions;
}
