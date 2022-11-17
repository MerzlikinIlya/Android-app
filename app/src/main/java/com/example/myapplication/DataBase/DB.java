package com.example.myapplication.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SportProgram.class}, version = 1)
public abstract class DB extends RoomDatabase {
    // инит-ия таблицы в БД
    public abstract SportProgramDAO taskDao();
}
