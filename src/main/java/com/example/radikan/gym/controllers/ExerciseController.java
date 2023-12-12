package com.example.radikan.gym.controllers;

import com.example.radikan.gym.exceptions.ErrorResponse;
import com.example.radikan.gym.models.Exercise;
import com.example.radikan.gym.services.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public ResponseEntity<?> addExercise(@RequestBody Exercise exercise) {
        return new ResponseEntity<>(exerciseService.addExercise(exercise), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateExercise(@PathVariable long id, @RequestBody Exercise updatedExercise) {
        Exercise updated = exerciseService.updateExercise(id, updatedExercise);
        if (updated != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updated);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("User not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllExercises() {
        return new ResponseEntity<>(exerciseService.getAllExercises(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getExerciseByName(@RequestBody String name) {
        return new ResponseEntity<>(exerciseService.getExerciseByName(name), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteExercise(@PathVariable long id) {
        exerciseService.deleteExercise(id);
        return new ResponseEntity<>("Exercise deleted successfully", HttpStatus.OK);
    }
}
