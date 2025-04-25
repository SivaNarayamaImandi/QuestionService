package com.quiz.QuestionService.controller;

import com.quiz.QuestionService.model.Question;
import com.quiz.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("add-question")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("get-questions")
    public ResponseEntity<List<Question>> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("get-questions/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("get-ques/{difficultyLevel}")
    public ResponseEntity<List<Question>> getQuestionsByDifficultyLevel(@PathVariable String difficultyLevel) {
        return questionService.getQuestionsByDifficultyLevel(difficultyLevel);
    }

    @GetMapping("get-questions/{difficultyLevel}/{category}")
    public ResponseEntity<List<Question>> getQuestionsByDifficultyLevelAndCategory(@PathVariable String difficultyLevel, @PathVariable String category) {
        return questionService.getQuestionsByDifficultyLevelAndCategory(difficultyLevel, category);
    }

    @DeleteMapping("delete-question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }
}
