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
        Exercise chest_ex1 = new Exercise(1L, "Chest Press Machine", 12, 100.0, true, "Monday");
        Exercise chest_ex2 = new Exercise(2L, "Inclined Bench Press", 12, 30.0, false, "Monday");
        Exercise chest_ex3 = new Exercise(3L, "Chest Flys Machine", 15, 25.0, true, "Monday");
        Exercise chest_ex4 = new Exercise(4L, "Push-Ups", 20, 0.0, false, "Monday");
        Exercise chest_ex5 = new Exercise(5L, "Dumbbell Pullover", 12, 35.0, false, "Monday");

        // Arms Exercises
        Exercise arms_ex1 = new Exercise(6L, "Bicep Curls", 15, 20.0, false, "Tuesday");
        Exercise arms_ex2 = new Exercise(7L, "Tricep Dips Machine", 12, 0.0, true, "Tuesday");
        Exercise arms_ex3 = new Exercise(8L, "Hammer Curls", 12, 25.0, false, "Tuesday");
        Exercise arms_ex4 = new Exercise(9L, "Cable Skull Crushers", 10, 40.0, true, "Tuesday");
        Exercise arms_ex5 = new Exercise(10L, "Pushdowns", 15, 35.0, false, "Tuesday");

        // Legs Exercises
        Exercise legs_ex1 = new Exercise(11L, "Squats", 10, 135.0, false, "Wednesday");
        Exercise legs_ex2 = new Exercise(12L, "Leg Press Machine", 8, 185.0, true, "Wednesday");
        Exercise legs_ex3 = new Exercise(13L, "Lunges", 12, 50.0, false, "Wednesday");
        Exercise legs_ex4 = new Exercise(14L, "Leg Extension Machine", 15, 180.0, true, "Wednesday");
        Exercise legs_ex5 = new Exercise(15L, "Calf Raises", 20, 50.0, false, "Wednesday");

        // Shoulders Exercises
        Exercise shoulders_ex1 = new Exercise(16L, "Military Press", 10, 75.0, false, "Thursday");
        Exercise shoulders_ex2 = new Exercise(17L, "Lateral Raises Machine", 15, 20.0, true, "Thursday");
        Exercise shoulders_ex3 = new Exercise(18L, "Front Raises", 12, 25.0, false, "Thursday");
        Exercise shoulders_ex4 = new Exercise(19L, "Shoulder Press Machine", 12, 60.0, true, "Thursday");
        Exercise shoulders_ex5 = new Exercise(20L, "Reverse Flys", 15, 15.0, false, "Thursday");

        // Legs Exercises for Saturday
        Exercise legs_ex6 = new Exercise(21L, "Deadlifts", 8, 185.0, false, "Saturday");
        Exercise legs_ex7 = new Exercise(22L, "Barbell Rows", 12, 65.0, false, "Saturday");
        Exercise legs_ex8 = new Exercise(23L, "Lat Pulldowns Machine", 15, 70.0, true, "Saturday");
        Exercise legs_ex9 = new Exercise(24L, "Hyperextensions", 12, 0.0, false, "Saturday");
        Exercise legs_ex10 = new Exercise(25L, "Pull-Ups", 10, 0.0, false, "Saturday");

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
