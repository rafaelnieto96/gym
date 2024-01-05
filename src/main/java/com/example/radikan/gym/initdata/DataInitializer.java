package com.example.radikan.gym.initdata;

import com.example.radikan.gym.models.Exercise;
import com.example.radikan.gym.repositories.ExerciseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ExerciseRepository exerciseRepository;

    public DataInitializer(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void run(String... args) {
        initializeData();
    }

    private void initializeData() {

        // Chest Exercises
        Exercise chest_ex1 = new Exercise(1L, "Chest Press Machine", 3, 12, 100.0, "Monday");
        Exercise chest_ex2 = new Exercise(2L, "Inclined Bench Press", 3, 12, 30.0, "Monday");
        Exercise chest_ex3 = new Exercise(3L, "Chest Flys Machine", 3, 15, 25.0, "Monday");
        Exercise chest_ex4 = new Exercise(4L, "Push-Ups", 3, 20, 0.0, "Monday");
        Exercise chest_ex5 = new Exercise(5L, "Dumbbell Pullover", 3, 12, 35.0, "Monday");

        // Arms Exercises
        Exercise arms_ex1 = new Exercise(6L, "Bicep Curls", 3, 15, 20.0, "Tuesday");
        Exercise arms_ex2 = new Exercise(7L, "Tricep Dips Machine", 3, 12, 0.0, "Tuesday");
        Exercise arms_ex3 = new Exercise(8L, "Hammer Curls", 4, 12, 25.0, "Tuesday");
        Exercise arms_ex4 = new Exercise(9L, "Cable Skull Crushers", 3, 10, 40.0, "Tuesday");
        Exercise arms_ex5 = new Exercise(10L, "Pushdowns", 3, 15, 35.0, "Tuesday");

        // Legs Exercises
        Exercise legs_ex1 = new Exercise(11L, "Squats", 3, 10, 135.0, "Wednesday");
        Exercise legs_ex2 = new Exercise(12L, "Leg Press Machine", 3, 8, 185.0, "Wednesday");
        Exercise legs_ex3 = new Exercise(13L, "Lunges", 4, 12, 50.0, "Wednesday");
        Exercise legs_ex4 = new Exercise(14L, "Leg Extension Machine", 3, 15, 180.0, "Wednesday");
        Exercise legs_ex5 = new Exercise(15L, "Calf Raises", 3, 20, 50.0, "Wednesday");

        // Shoulders Exercises
        Exercise shoulders_ex1 = new Exercise(16L, "Military Press", 3, 10, 75.0, "Thursday");
        Exercise shoulders_ex2 = new Exercise(17L, "Lateral Raises Machine", 3, 15, 20.0, "Thursday");
        Exercise shoulders_ex3 = new Exercise(18L, "Front Raises", 3, 12, 25.0, "Thursday");
        Exercise shoulders_ex4 = new Exercise(19L, "Shoulder Press Machine", 3, 12, 60.0, "Thursday");
        Exercise shoulders_ex5 = new Exercise(20L, "Reverse Flys", 3, 15, 15.0, "Thursday");

        // Legs Exercises for Saturday
        Exercise legs_ex6 = new Exercise(21L, "Deadlifts", 3, 8, 185.0, "Saturday");
        Exercise legs_ex7 = new Exercise(22L, "Barbell Rows", 3, 12, 65.0, "Saturday");
        Exercise legs_ex8 = new Exercise(23L, "Lat Pulldowns Machine", 3, 15, 70.0, "Saturday");
        Exercise legs_ex9 = new Exercise(24L, "Hyperextensions", 3, 12, 0.0, "Saturday");
        Exercise legs_ex10 = new Exercise(25L, "Pull-Ups", 3, 10, 0.0, "Saturday");

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(chest_ex1);
        exercises.add(chest_ex2);
        exercises.add(chest_ex3);
        exercises.add(chest_ex4);
        exercises.add(chest_ex5);
        exercises.add(arms_ex1);
        exercises.add(arms_ex2);
        exercises.add(arms_ex3);
        exercises.add(arms_ex4);
        exercises.add(arms_ex5);
        exercises.add(legs_ex1);
        exercises.add(legs_ex2);
        exercises.add(legs_ex3);
        exercises.add(legs_ex4);
        exercises.add(legs_ex5);
        exercises.add(shoulders_ex1);
        exercises.add(shoulders_ex2);
        exercises.add(shoulders_ex3);
        exercises.add(shoulders_ex4);
        exercises.add(shoulders_ex5);
        // Add Saturday leg exercises
        exercises.add(legs_ex6);
        exercises.add(legs_ex7);
        exercises.add(legs_ex8);
        exercises.add(legs_ex9);
        exercises.add(legs_ex10);

        exerciseRepository.saveAll(exercises);
    }
}
