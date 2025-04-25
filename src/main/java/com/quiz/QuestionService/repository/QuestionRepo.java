package com.quiz.QuestionService.repository;

import com.quiz.QuestionService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    List<Question> findByDifficultyLevelAndCategory(String difficultyLevel, String category);

    List<Question> findByDifficultyLevel(String difficultyLevel);

    @Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numberOfQuestions", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numberOfQuestions);
}
