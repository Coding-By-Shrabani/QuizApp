package com.project.QuizApp.Controller;

import com.project.QuizApp.Service.QuizService;
import com.project.QuizApp.question.Question;
import com.project.QuizApp.question.QuestionWrapper;
import com.project.QuizApp.question.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    //handles HTTP requests
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category , @RequestParam int numbQ,@RequestParam String title){
        return  quizService.createQuiz(category ,numbQ ,title);
    }
    @GetMapping("get/{id}")
    public  ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return   quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> responses){
  return quizService.calculateResult(id , responses);
    }
}
