package com.example.finalnewsapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.finalnewsapp.model.SourceResponse.SourcesItem;

import java.util.List;

@Dao
public interface SourceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAllSources(List<SourcesItem> sourcesItemList);

    @Query("select * from sourcesItem")
    List<SourcesItem> getAllSources();

}
