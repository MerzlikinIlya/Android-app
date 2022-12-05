package com.example.myapplication.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Exercise {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String name;
    @ColumnInfo
    private String desc;
    @ColumnInfo
    private int amount;
    @ColumnInfo
    private int repeats;
    @ColumnInfo
    private int time;



    public Exercise(String name, String desc,int amount, int repeats, int time) {
        this.name = name;
        this.desc = desc;
        this.amount = amount;
        this.repeats = repeats;
        this.time = time;
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

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRepeats() {
        return repeats;
    }
    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }

}
