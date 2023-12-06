package com.example.radikan.gym.initdata;

import com.example.radikan.gym.models.Day;
import com.example.radikan.gym.models.Exercise;
import com.example.radikan.gym.repositories.DayRepository;
import com.example.radikan.gym.repositories.ExerciseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DayRepository dayRepository;
    private final ExerciseRepository exerciseRepository;

    public DataInitializer(DayRepository dayRepository, ExerciseRepository exerciseRepository) {
        this.dayRepository = dayRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void run(String... args) {
        initializeData();
    }

    private void initializeData() {

        // Chest Exercises
        Exercise chest_ex1 = new Exercise(1L, "Chest Press Machine", 12, 100.0, true); // Changed
        Exercise chest_ex2 = new Exercise(2L, "Inclined Bench Press", 12, 30.0, false);
        Exercise chest_ex3 = new Exercise(3L, "Chest Flys Machine", 15, 25.0, true); // Changed
        Exercise chest_ex4 = new Exercise(4L, "Push-Ups", 20, 0.0, false);
        Exercise chest_ex5 = new Exercise(5L, "Dumbbell Pullover", 12, 35.0, false);

        // Arms Exercises
        Exercise arms_ex1 = new Exercise(6L, "Bicep Curls", 15, 20.0, false);
        Exercise arms_ex2 = new Exercise(7L, "Tricep Dips Machine", 12, 0.0, true); // Changed
        Exercise arms_ex3 = new Exercise(8L, "Hammer Curls", 12, 25.0, false);
        Exercise arms_ex4 = new Exercise(9L, "Cable Skull Crushers", 10, 40.0, true); // Changed
        Exercise arms_ex5 = new Exercise(10L, "Pushdowns", 15, 35.0, false);

        // Legs Exercises
        Exercise legs_ex1 = new Exercise(11L, "Squats", 10, 135.0, false);
        Exercise legs_ex2 = new Exercise(12L, "Leg Press Machine", 8, 185.0, true); // Changed
        Exercise legs_ex3 = new Exercise(13L, "Lunges", 12, 50.0, false);
        Exercise legs_ex4 = new Exercise(14L, "Leg Extension Machine", 15, 180.0, true); // Changed
        Exercise legs_ex5 = new Exercise(15L, "Calf Raises", 20, 50.0, false);

        // Shoulders Exercises
        Exercise shoulders_ex1 = new Exercise(16L, "Military Press", 10, 75.0, false);
        Exercise shoulders_ex2 = new Exercise(17L, "Lateral Raises Machine", 15, 20.0, true); // Changed
        Exercise shoulders_ex3 = new Exercise(18L, "Front Raises", 12, 25.0, false);
        Exercise shoulders_ex4 = new Exercise(19L, "Shoulder Press Machine", 12, 60.0, true); // Changed
        Exercise shoulders_ex5 = new Exercise(20L, "Reverse Flys", 15, 15.0, false);

        // Back Exercises
        Exercise back_ex1 = new Exercise(21L, "Pull-Ups", 10, 0.0, false);
        Exercise back_ex2 = new Exercise(22L, "Deadlifts", 8, 185.0, false);
        Exercise back_ex3 = new Exercise(23L, "Barbell Rows", 12, 65.0, false);
        Exercise back_ex4 = new Exercise(24L, "Lat Pulldowns Machine", 15, 70.0, true); // Changed
        Exercise back_ex5 = new Exercise(25L, "Hyperextensions", 12, 0.0, false);


        List<Exercise> monday_exercises = new ArrayList<>();
        monday_exercises.add(chest_ex1);
        monday_exercises.add(chest_ex2);
        monday_exercises.add(chest_ex3);
        monday_exercises.add(chest_ex4);
        monday_exercises.add(chest_ex5);

        Day chestDay = new Day(1L, "Chest", monday_exercises);

        dayRepository.save(chestDay);
        exerciseRepository.save(chest_ex1);
        exerciseRepository.save(chest_ex2);
        exerciseRepository.save(chest_ex3);
        exerciseRepository.save(chest_ex4);
        exerciseRepository.save(chest_ex5);


        List<Exercise> tuesday_exercises = new ArrayList<>();
        tuesday_exercises.add(arms_ex1);
        tuesday_exercises.add(arms_ex2);
        tuesday_exercises.add(arms_ex3);
        tuesday_exercises.add(arms_ex4);
        tuesday_exercises.add(arms_ex5);

        Day armsDay = new Day(2L, "Arms", tuesday_exercises);

        dayRepository.save(armsDay);
        exerciseRepository.save(arms_ex1);
        exerciseRepository.save(arms_ex2);
        exerciseRepository.save(arms_ex3);
        exerciseRepository.save(arms_ex4);
        exerciseRepository.save(arms_ex5);


        List<Exercise> wednesday_exercises = new ArrayList<>();
        wednesday_exercises.add(legs_ex1);
        wednesday_exercises.add(legs_ex2);
        wednesday_exercises.add(legs_ex3);
        wednesday_exercises.add(legs_ex4);
        wednesday_exercises.add(legs_ex5);

        Day legsDay = new Day(3L, "Legs", wednesday_exercises);

        dayRepository.save(legsDay);
        exerciseRepository.save(legs_ex1);
        exerciseRepository.save(legs_ex2);
        exerciseRepository.save(legs_ex3);
        exerciseRepository.save(legs_ex4);
        exerciseRepository.save(legs_ex5);


        List<Exercise> thursday_exercises = new ArrayList<>();
        thursday_exercises.add(shoulders_ex1);
        thursday_exercises.add(shoulders_ex2);
        thursday_exercises.add(shoulders_ex3);
        thursday_exercises.add(shoulders_ex4);
        thursday_exercises.add(shoulders_ex5);

        Day shouldersDay = new Day(4L, "Shoulders", thursday_exercises);

        dayRepository.save(shouldersDay);
        exerciseRepository.save(shoulders_ex1);
        exerciseRepository.save(shoulders_ex2);
        exerciseRepository.save(shoulders_ex3);
        exerciseRepository.save(shoulders_ex4);
        exerciseRepository.save(shoulders_ex5);


        List<Exercise> friday_exercises = new ArrayList<>();
        friday_exercises.add(back_ex1);
        friday_exercises.add(back_ex2);
        friday_exercises.add(back_ex3);
        friday_exercises.add(back_ex4);
        friday_exercises.add(back_ex5);

        Day backDay = new Day(5L, "Back", friday_exercises);

        dayRepository.save(backDay);
        exerciseRepository.save(back_ex1);
        exerciseRepository.save(back_ex2);
        exerciseRepository.save(back_ex3);
        exerciseRepository.save(back_ex4);
        exerciseRepository.save(back_ex5);

    }
}
