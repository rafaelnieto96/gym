package com.example.radikan.gym.controllers;

import com.example.radikan.gym.models.Exercise;
import com.example.radikan.gym.services.ExerciseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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

    private ExerciseController exerciseController;

    @BeforeEach
    void setUp() {
        exerciseController = new ExerciseController(exerciseService);
    }

    @Test
    void addExercise() {
        // Given
        Exercise exerciseToAdd = new Exercise(1L, "Test Exercise", 1, 100.0, true);
        ResponseEntity<Exercise> expectedResponse = new ResponseEntity<>(exerciseToAdd, HttpStatus.CREATED);
        when(exerciseService.addExercise(exerciseToAdd)).thenReturn(expectedResponse.getBody());

        // When
        ResponseEntity<?> response = exerciseController.addExercise(exerciseToAdd);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void updateExercise() {
        // Given
        long exerciseId = 1L;
        Exercise updatedExercise = new Exercise(1L, "Updated Test Exercise", 2, 120.0, false);
        ResponseEntity<Exercise> expectedResponse = new ResponseEntity<>(updatedExercise, HttpStatus.CREATED);
        when(exerciseService.updateExercise(exerciseId, updatedExercise)).thenReturn(expectedResponse.getBody());

        // When
        ResponseEntity<?> response = exerciseController.updateExercise(exerciseId, updatedExercise);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("GIVEN  WHEN THEN return ")
    void getAllExercises() {
        // Given
        List<Exercise> exercises = new ArrayList<>();
        Exercise chest_ex1 = new Exercise(1L, "Chest Press Machine", 12, 100.0, true);
        Exercise chest_ex2 = new Exercise(2L, "Inclined Bench Press", 12, 30.0, false);
        exercises.add(chest_ex1);
        exercises.add(chest_ex2);
        when(exerciseService.getAllExercises()).thenReturn(exercises);

        // When
        ResponseEntity<?> response = exerciseController.getAllExercises();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getExerciseByName() {
        // Given
        String exerciseName = "Test Exercise";
        Exercise exerciseToReturn = new Exercise(1L, "Test Exercise", 1, 100.0, true);
        List<Exercise> exercises = List.of(exerciseToReturn);
        when(exerciseService.getExerciseByName(exerciseName)).thenReturn(exercises);

        // When
        ResponseEntity<?> response = exerciseController.getExerciseByName(exerciseName);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteExercise() {
        // Given
        long exerciseId = 1L;
        ResponseEntity<?> expectedResponse = new ResponseEntity<>("Exercise deleted successfully", HttpStatus.OK);
        doNothing().when(exerciseService).deleteExercise(exerciseId);

        // When
        ResponseEntity<?> response = exerciseController.deleteExercise(exerciseId);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(exerciseService, times(1)).deleteExercise(exerciseId);
    }
}
