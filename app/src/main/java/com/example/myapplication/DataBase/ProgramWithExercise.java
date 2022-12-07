package com.example.myapplication.DataBase;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class ProgramWithExercise {
    @Embedded public SportProgram program;
    @Relation(
            parentColumn = "idProgram",
            entityColumn = "idExercise",
            associateBy =  @Junction(TableRef.class)
    )public List<Exercise> exercises;
}
