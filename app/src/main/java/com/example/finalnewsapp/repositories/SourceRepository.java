package com.example.finalnewsapp.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.finalnewsapp.Constant;
import com.example.finalnewsapp.api.APIManager;
import com.example.finalnewsapp.database.MyDataBase;
import com.example.finalnewsapp.model.SourceResponse.SourceResponse;
import com.example.finalnewsapp.model.SourceResponse.SourcesItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SourceRepository {

    public MutableLiveData<List<SourcesItem>> cacheSourcesList = new MutableLiveData<>();

    public void getSources(){
        APIManager.getApis().getNewsSource(Constant.API_KEY)
                .enqueue(new Callback<SourceResponse>() {
                    @Override
                    public void onResponse(Call<SourceResponse> call, Response<SourceResponse> response) {
                        cacheSources(response.body().getSources());
                        cacheSourcesList.setValue(response.body().getSources());
                    }

                    @Override
                    public void onFailure(Call<SourceResponse> call, Throwable t) {
                        getSourcesFromCache();
                    }
                });
    }

    private void getSourcesFromCache() {
        getSourceThread thread = new getSourceThread();
        thread.start();
    }

    private void cacheSources(final List<SourcesItem> sources) {

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                MyDataBase.getInstance().sourceDao().addAllSources(sources);
            }
        };
        thread.start();
    }

    public class getSourceThread extends Thread{
        @Override
        public void run() {
            super.run();
            List<SourcesItem> sourcesItems = MyDataBase.getInstance().sourceDao().getAllSources();
            cacheSourcesList.postValue(sourcesItems);
        }
    }

}
