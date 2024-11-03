package com.project.QuizApp.Controller;


import com.project.QuizApp.Service.QuestionService;
import com.project.QuizApp.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;


    //Read Operation
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }
@GetMapping("category/{category}")  //When we give a particular path to the address bar , then that particular which is in {} that will assign to String object category
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String  category){
            return questionService.getQuestionsByCategory(category);
    }

    //Create Operation
    @PostMapping("add")
    public ResponseEntity<String> addQuestion( @RequestBody Question question){
        return questionService.addQuestion(question);
    }

//Update Operation
    @PutMapping("question/{slno}")
    public ResponseEntity<Integer> updateQuestion(@PathVariable int slno, @RequestBody Question updatedQuestion){
        return questionService.updateQuestion(slno,updatedQuestion);
    }

    //Delete Operation
    @DeleteMapping("slno/{slno}")
    public ResponseEntity<Integer> deleteCategory(@PathVariable int slno){
            return questionService.deleteCategory(slno);
    }
}
