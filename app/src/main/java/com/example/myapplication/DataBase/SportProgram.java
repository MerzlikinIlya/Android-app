package com.example.myapplication.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;


@Entity
public class SportProgram {

    @PrimaryKey(autoGenerate = true)
    public int idProgram;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String desc;



    public SportProgram(String name, String desc) {
        this.name = name;
        this.desc = desc;

    }
    public int getIdProgram() {return idProgram;}

    public void setIdProgram(int id) {
        this.idProgram = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
