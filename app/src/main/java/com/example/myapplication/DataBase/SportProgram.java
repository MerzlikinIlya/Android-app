package com.example.myapplication.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;


@Entity
public class SportProgram {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String desc;
    //@ColumnInfo
    //private List<String> listPrograms;


    public SportProgram(String name, String desc) {
        this.name = name;
        this.desc = desc;
        //this.listPrograms = listPrograms;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String task) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    //public List<String> getListPrograms() {return listPrograms;}
    //public void setListPrograms(List<String> listPrograms){this.listPrograms = listPrograms;}
}
