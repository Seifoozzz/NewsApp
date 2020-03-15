package com.example.finalnewsapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.finalnewsapp.database.daos.NewsDao;
import com.example.finalnewsapp.model.NewsRespnse.ArticlesItem;
import com.example.finalnewsapp.model.SourceResponse.SourcesItem;

@Database(exportSchema = false,version = 5,entities = {SourcesItem.class, ArticlesItem.class})
public abstract class MyDataBase extends RoomDatabase {

    private static MyDataBase myDataBase;

    public abstract SourceDao sourceDao();

    public abstract NewsDao newsDao();

    public static MyDataBase getInstance(){
        if (myDataBase == null)
            throw new NullPointerException("database is null");
        return myDataBase;
    }

    public static void init(Context context){
        myDataBase = Room.databaseBuilder(context,MyDataBase.class
                ,"newsAppDatabase")
                .fallbackToDestructiveMigration()
                .build();
    }
}
