package com.project.QuizApp.Service;

import com.project.QuizApp.dao.QuestionDao;
import com.project.QuizApp.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    //Read Operation
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    //Create Operation
    public ResponseEntity<String> addQuestion(Question question) {
         questionDao.save(question);
         try{
             return new ResponseEntity<>("Success",HttpStatus.CREATED);
         }catch (Exception e){
             e.printStackTrace();
         }
         return new ResponseEntity<>("Question Is not Added!",HttpStatus.BAD_REQUEST);
    }

    //Delete Operation
    public ResponseEntity<Integer> deleteCategory(int slno) {
        try {
            int result = questionDao.deleteBySlno(slno);
            if (result>0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //Update Operation
    public ResponseEntity<Integer> updateQuestion(int slno, Question updatedQuestion) {
        try {
            String questions = updatedQuestion.getQuestions();
            int result = questionDao.updateBySlno(slno, questions);
            if (result > 0) {
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
