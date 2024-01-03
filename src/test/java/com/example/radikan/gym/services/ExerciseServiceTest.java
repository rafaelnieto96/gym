package com.example.radikan.gym.services;

import com.example.radikan.gym.models.Exercise;
import com.example.radikan.gym.repositories.ExerciseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExerciseServiceTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private ExerciseService exerciseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Add Exercise")
    void addExercise() {
        // Given
        Exercise exerciseToAdd = new Exercise(1L, "Test Exercise", 1, 100.0, true, "Monday");
        when(exerciseRepository.save(exerciseToAdd)).thenReturn(exerciseToAdd);

        // When
        Exercise addedExercise = exerciseService.addExercise(exerciseToAdd);

        // Then
        assertNotNull(addedExercise);
        assertEquals("Test Exercise", addedExercise.getName());
    }

    @Test
    @DisplayName("Update Exercise")
    void updateExercise() {
        // Given
        long exerciseId = 1L;
        Exercise updatedExercise = new Exercise(1L, "Updated Test Exercise", 2, 120.0, false, "Monday");
        Exercise existingExercise = new Exercise(1L, "Existing Exercise", 1, 100.0, true, "Monday");
        when(exerciseRepository.findById(exerciseId)).thenReturn(Optional.of(existingExercise));
        when(exerciseRepository.save(existingExercise)).thenReturn(existingExercise);

        // When
        Exercise result = exerciseService.updateExercise(exerciseId, updatedExercise);

        // Then
        assertNotNull(result);
        assertEquals("Updated Test Exercise", result.getName());
        assertEquals(2, result.getRepetitions());
    }

    @Test
    @DisplayName("Get All Exercises")
    void getAllExercises() {
        // Given
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise(1L, "Chest Press Machine", 12, 100.0, true, "Monday"));
        exercises.add(new Exercise(2L, "Inclined Bench Press", 12, 30.0, false, "Monday"));
        when(exerciseRepository.findAll()).thenReturn(exercises);

        // When
        List<Exercise> result = exerciseService.getAllExercises();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Get Exercise By Name")
    void getExerciseByName() {
        // Given
        String exerciseName = "Test Exercise";
        List<Exercise> exercises = Collections.singletonList(new Exercise(1L, "Test Exercise", 1, 100.0, true, "Monday"));
        when(exerciseRepository.findByName(exerciseName)).thenReturn(Optional.of(exercises));

        // When
        List<Exercise> result = exerciseService.getExerciseByName(exerciseName);

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Exercise", result.get(0).getName());
    }

    @Test
    @DisplayName("Delete Exercise")
    void deleteExercise() {
        // Given
        long exerciseId = 1L;
        when(exerciseRepository.findById(exerciseId)).thenReturn(Optional.of(new Exercise()));

        // When
        assertDoesNotThrow(() -> exerciseService.deleteExercise(exerciseId));

        // Then
        verify(exerciseRepository, times(1)).deleteById(exerciseId);
    }

    @Test
    @DisplayName("Delete Exercise - Exercise Not Found")
    void deleteExercise_ExerciseNotFound() {
        // Given
        long exerciseId = 1L;
        when(exerciseRepository.findById(exerciseId)).thenReturn(Optional.empty());

        // When
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> exerciseService.deleteExercise(exerciseId));

        // Then
        assertEquals("Exercise not found", exception.getMessage());
        verify(exerciseRepository, never()).deleteById(exerciseId);
    }
}
