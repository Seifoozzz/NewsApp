package com.example.finalnewsapp.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalnewsapp.model.NewsRespnse.ArticlesItem;
import com.example.finalnewsapp.model.SourceResponse.SourcesItem;
import com.example.finalnewsapp.repositories.NewsRepository;
import com.example.finalnewsapp.repositories.SourceRepository;

import java.util.List;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<SourcesItem>> sourceList;
    MutableLiveData<List<ArticlesItem>> newsList;
    MutableLiveData<String> message = new MutableLiveData<>();
    MutableLiveData<Boolean> showProgressBar = new MutableLiveData<>();

    SourceRepository repository = new SourceRepository();
    NewsRepository newsRepository = new NewsRepository();

    public MainViewModel(){
        sourceList = repository.cacheSourcesList;
        newsList = newsRepository.articlesItem;
    }

    public void getNewsSources(){
        showProgressBar.setValue(true);
        repository.getSources();
    }

    public void getNewsResourcesById(String sourceID) {
        showProgressBar.setValue(true);
        newsRepository.getNewsSources(sourceID);
    }

    /*
    APIManager.getApis().getNewsBySourceId(Constant.API_KEY,sourceID)
                .enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        showProgressBar.setValue(false);
                        if ("ok".equals(response.body().status)){
                            newsList.setValue(response.body().articles);
                        }else {
                            message.setValue(response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        showProgressBar.setValue(false);
                        message.setValue(t.getLocalizedMessage());
                    }
                });
     */
}
