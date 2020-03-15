package com.example.finalnewsapp.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.finalnewsapp.Constant;
import com.example.finalnewsapp.api.APIManager;
import com.example.finalnewsapp.database.MyDataBase;
import com.example.finalnewsapp.model.NewsRespnse.ArticlesItem;
import com.example.finalnewsapp.model.NewsRespnse.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    public MutableLiveData<List<ArticlesItem>> articlesItem = new MutableLiveData<>();

    public void getNewsSources(String sourceId){
        APIManager.getApis().getNewsBySourceId(Constant.API_KEY,sourceId)
                .enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        if ("ok".equals(response.body().status)) {
                            cacheNews(response.body().articles);
                            articlesItem.setValue(response.body().articles);

                        }
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        getNewsFromCache();
                    }
                });
    }

    private void getNewsFromCache() {
        getNewsThread thread = new getNewsThread();
        thread.start();
    }

    private void cacheNews(final List<ArticlesItem> articles) {

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                MyDataBase.getInstance().newsDao().addAllArticles(articles);
            }
        };
        thread.start();
    }

    public class getNewsThread extends Thread{
        @Override
        public void run() {
            super.run();
            List<ArticlesItem> articlesItemList = MyDataBase.getInstance()
                    .newsDao().getAllArticles();
            articlesItem.postValue(articlesItemList);
        }
    }
}
