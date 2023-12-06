package com.example.radikan.gym.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "days")
@AllArgsConstructor
@NoArgsConstructor
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bodyPart;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "day_id")
    private List<Exercise> exercises;

}