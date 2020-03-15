package com.example.finalnewsapp.database.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.finalnewsapp.model.NewsRespnse.ArticlesItem;

import java.util.List;

@Dao
public interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAllArticles(List<ArticlesItem> articlesItemList);

    @Query("select * from articlesitem")
    List<ArticlesItem> getAllArticles();
}
