package com.project.QuizApp.dao;

import com.project.QuizApp.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository //indicates that QuestionDao is a repository , which interacts with database to manage the entities
public interface QuestionDao extends JpaRepository<Question,Integer> {

  List<Question> findByCategory(String category);
  // Delete operation
    @Modifying  //to indicate that the query method modifies the data (it is not a SELECT query).
    @Transactional   //is used to specify that the method should be executed within a database transaction.
    @Query("DELETE FROM Question WHERE slno = :slno")
    int deleteBySlno(int slno);

  @Modifying
  @Transactional
  @Query("UPDATE Question q SET q.questions = :questions WHERE q.slno = :slno")
  int updateBySlno(int slno, String questions);

    //This indicates that the query is a native SQL query. Spring will execute it directly against the database.
@Query(value = "SELECT * FROM question q where q.category =:category ORDER BY RANDOM() LIMIT :numbQ",nativeQuery = true)
  List<Question> findRandomQuestionsByCategory(String category , int numbQ);


}
