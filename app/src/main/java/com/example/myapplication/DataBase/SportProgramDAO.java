package com.example.myapplication.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Flowable;
@Dao
public interface SportProgramDAO {


        @Query("SELECT * FROM sportprogram")
        Flowable<List<SportProgram>> getAll();

        @Insert
        void insert(SportProgram sp);

        @Delete
        void delete(SportProgram sp);

        @Update
        void update(SportProgram sp);


}
