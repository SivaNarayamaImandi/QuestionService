package com.quiz.QuestionService.service;

import com.quiz.QuestionService.model.Question;
import com.quiz.QuestionService.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> addQuestion(Question question) {
        if (questionRepo.save(question) != null) {
            try {
                return new ResponseEntity<String>("Question Added Successful.....", HttpStatus.CREATED);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<String>("Question Added Failed.....", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<List<Question>> getQuestions() {
        if (!questionRepo.findAll().isEmpty()) {
            try {
                return new ResponseEntity<List<Question>>(questionRepo.findAll(), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<List<Question>>(questionRepo.findAll(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        if (!questionRepo.findByCategory(category).isEmpty()) {
            try {
                return new ResponseEntity<List<Question>>(questionRepo.findByCategory(category), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<List<Question>>(questionRepo.findByCategory(category), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Question>> getQuestionsByDifficultyLevel(String difficultyLevel) {
        if (!questionRepo.findByDifficultyLevel(difficultyLevel).isEmpty()) {
            try {
                return new ResponseEntity<List<Question>>(questionRepo.findByDifficultyLevel(difficultyLevel), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<List<Question>>(questionRepo.findByDifficultyLevel(difficultyLevel), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Question>> getQuestionsByDifficultyLevelAndCategory(String difficultyLevel, String category) {
        if (!questionRepo.findByDifficultyLevelAndCategory(difficultyLevel, category).isEmpty()) {
            try {
                return new ResponseEntity<List<Question>>(questionRepo.findByDifficultyLevelAndCategory(difficultyLevel, category), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<List<Question>>(questionRepo.findByDifficultyLevelAndCategory(difficultyLevel, category), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try {
            questionRepo.deleteById(id);
            return new ResponseEntity<String>("Question Deleted Successful.....", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Question Deleted Failed.....", HttpStatus.BAD_REQUEST);
    }
}
