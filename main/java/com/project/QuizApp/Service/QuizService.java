package com.project.QuizApp.Service;

import com.project.QuizApp.dao.QuestionDao;
import com.project.QuizApp.dao.QuizDao;
import com.project.QuizApp.question.Question;
import com.project.QuizApp.question.QuestionWrapper;
import com.project.QuizApp.question.Quiz;
import com.project.QuizApp.question.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category , int numbQ, String title){
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numbQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return  new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question>  questionsFromdb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for (Question q:questionsFromdb){
            QuestionWrapper qw = new QuestionWrapper(q.getSlno(),q.getQuestions(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }
        return  new ResponseEntity<>(questionsForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for (Response response:responses){
            if (response.getResponse().equals(questions.get(i).getAnswers()))
                right++;

            i++;
            }
        return new ResponseEntity<>(right, HttpStatus.OK);

        }

    }

