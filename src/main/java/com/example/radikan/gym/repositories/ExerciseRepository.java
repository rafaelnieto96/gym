package com.example.radikan.gym.repositories;

import com.example.radikan.gym.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
}
