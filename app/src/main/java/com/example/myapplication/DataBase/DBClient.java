package com.example.myapplication.DataBase;

import android.content.Context;
import androidx.room.Room;


public class DBClient {

    private Context mCtx;
    private static DBClient mInstance;

    private DB mainDatabase;

    private DBClient(Context mCtx) {
        this.mCtx = mCtx;
        //Создание БД - MyToDos
        mainDatabase = Room.databaseBuilder(mCtx, DB.class, "MySportPrograms").build();
    }

    public static DBClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DBClient(mCtx);
        }
        return mInstance;
    }

    public DB getAppDatabase() {
        return mainDatabase;
    }
}
