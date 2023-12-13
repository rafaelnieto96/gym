package com.example.radikan.gym.services;

import com.example.radikan.gym.models.Exercise;
import com.example.radikan.gym.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise addExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercise updateExercise(long id, Exercise updatedExercise) {
        Exercise existingExercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Exercise not found"));

        existingExercise.setName(updatedExercise.getName());
        existingExercise.setRepetitions(updatedExercise.getRepetitions());
        existingExercise.setWeight(updatedExercise.getWeight());
        existingExercise.setMachine(updatedExercise.isMachine());

        return exerciseRepository.save(existingExercise);
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public List<Exercise> getExerciseByName(String name) {
        return exerciseRepository.findByName(name)
                .orElse(Collections.emptyList());
    }

    public void deleteExercise(long id) {
        exerciseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Exercise not found"));

        exerciseRepository.deleteById(id);
    }

}
