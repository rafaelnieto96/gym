package com.example.radikan.gym.repositories;

import com.example.radikan.gym.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

    Optional<List<Exercise>> findByName(String name);

}
