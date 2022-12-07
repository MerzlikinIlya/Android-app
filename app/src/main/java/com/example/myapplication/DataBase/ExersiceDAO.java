package com.example.myapplication.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ExersiceDAO {


        @Query("SELECT * FROM exercise")
        Flowable<List<Exercise>> getExercise();

        @Insert
        void insert(Exercise ex);

        @Delete
        void delete(Exercise ex);

        @Update
        void update(Exercise ex);


}
