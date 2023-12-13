package com.example.radikan.gym.controllers;

import com.example.radikan.gym.models.Exercise;
import com.example.radikan.gym.services.ExerciseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExerciseControllerTest {

    @Mock
    private ExerciseService exerciseService;

    @InjectMocks
    private ExerciseController exerciseController;

    @Test
    @DisplayName("GIVEN a valid exercise WHEN addExercise method is called THEN return the exercise and HTTP Created status")
    void addExercise() {
        // Given
        Exercise validExercise = new Exercise(1L, "Test Exercise", 1, 100.0, true);
        ResponseEntity<Exercise> expectedResponse = new ResponseEntity<>(validExercise, HttpStatus.CREATED);
        when(exerciseService.addExercise(validExercise)).thenReturn(expectedResponse.getBody());

        // When
        ResponseEntity<?> response = exerciseController.addExercise(validExercise);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @DisplayName("GIVEN an exercise id and updated details WHEN updateExercise method is called THEN return HTTP OK status")
    void updateExercise() {
        // Given
        long exerciseId = 1L;
        Exercise updatedExercise = new Exercise(1L, "Updated Test Exercise", 2, 120.0, false);
        ResponseEntity<Exercise> expectedResponse = new ResponseEntity<>(updatedExercise, HttpStatus.OK);
        when(exerciseService.updateExercise(exerciseId, updatedExercise)).thenReturn(expectedResponse.getBody());

        // When
        ResponseEntity<?> response = exerciseController.updateExercise(exerciseId, updatedExercise);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("GIVEN a list of exercises WHEN getAllExercises method is called THEN return HTTP OK status")
    void getAllExercises() {
        // Given
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise(1L, "Chest Press Machine", 12, 100.0, true));
        exercises.add(new Exercise(2L, "Inclined Bench Press", 12, 30.0, false));
        when(exerciseService.getAllExercises()).thenReturn(exercises);

        // When
        ResponseEntity<?> response = exerciseController.getAllExercises();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("GIVEN an exercise name WHEN getExerciseByName method is called THEN return HTTP OK status")
    void getExerciseByName() {
        // Given
        String exerciseName = "Test Exercise";
        List<Exercise> exercises = List.of(new Exercise(1L, "Test Exercise", 1, 100.0, true));
        when(exerciseService.getExerciseByName(exerciseName)).thenReturn(exercises);

        // When
        ResponseEntity<?> response = exerciseController.getExerciseByName(exerciseName);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("GIVEN an exercise id WHEN deleteExercise method is called THEN return HTTP OK status")
    void deleteExercise() {
        // Given
        long exerciseId = 1L;
        doNothing().when(exerciseService).deleteExercise(exerciseId);

        // When
        ResponseEntity<?> response = exerciseController.deleteExercise(exerciseId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(exerciseService, times(1)).deleteExercise(exerciseId);
    }
}
