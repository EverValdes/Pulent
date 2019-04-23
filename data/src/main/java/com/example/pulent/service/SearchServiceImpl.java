package com.example.pulent.service;

import com.example.pulent.builder.RetrofitBuilder;
import com.example.pulent.dto.SongDTO;
import com.example.pulent.dto.ResultDTO;
import com.example.pulent.api.SearchApiService;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchServiceImpl implements SearchService {
    private static final int SEARCH_TIMEOUT_MILLI = 1000;
    private SearchApiService searchApiService;
    private PublishSubject<CharSequence> queryObservable;


    private void init(String text, final Callback<ResultDTO> callback) {
        searchApiService = RetrofitBuilder.getRetrofit().create(SearchApiService.class);

        Observer<CharSequence> observer = new Observer<CharSequence>() {
            @Override public void onSubscribe(Disposable d) { }
            @Override public void onComplete() { }

            @Override
            public void onNext(CharSequence s) {
                if (s.length() > 0) {
                    searchApiService.getSearchResults(s, SearchApiService.TYPE_MUSIC_TRACK).enqueue(callback);

                }
            }

            @Override
            public void onError(Throwable e) {

            }
        };

        queryObservable = PublishSubject.create();
        queryObservable.debounce(SEARCH_TIMEOUT_MILLI, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(observer);

        queryObservable.onNext(text);
    }

    @Override
    public void searchForText(String text, Callback<ResultDTO> callback) {
        init(text, callback);
    }
}
