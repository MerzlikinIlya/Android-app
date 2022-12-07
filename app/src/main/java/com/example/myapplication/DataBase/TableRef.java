package com.example.myapplication.DataBase;

import androidx.room.Entity;

@Entity(primaryKeys = {"idProgram","idExercise"})
public class TableRef {
    public int idProgram;
    public int idExercise;
}
