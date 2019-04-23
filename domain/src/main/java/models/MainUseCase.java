package models;

import com.example.pulent.builder.RetrofitBuilder;
import com.example.pulent.service.SearchService;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

import java.util.concurrent.TimeUnit;

public class MainUseCase {
    private static final int SEARCH_TIMEOUT_MILLI = 1000;
    private SearchService searchService;
    private PublishSubject<CharSequence> queryObservable;


    public void init() {
        searchService = RetrofitBuilder.getRetrofit().create(SearchService.class);

        queryObservable = PublishSubject.create();
        queryObservable.debounce(SEARCH_TIMEOUT_MILLI, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<CharSequence>() {
            @Override public void onSubscribe(Disposable d) { }
            @Override public void onComplete() { }

            @Override
            public void onNext(CharSequence s) {
                if (s.length() > 0) {

                    searchService.getSearchResults(s, SearchService.ENTITY_TYPE_MUSIC_TRACK);

                }
            }

            @Override
            public void onError(Throwable e) {
                String lala;
            }
        });
    }

    public void next(String text) {
        queryObservable.onNext(text);
    }
}
