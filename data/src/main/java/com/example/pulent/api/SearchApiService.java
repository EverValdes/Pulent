package com.example.pulent.api;


import com.example.pulent.dto.ResultDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchApiService {

    String TYPE_MUSIC_TRACK = "musicTrack";

    @GET("search")
    Call<ResultDTO> getSearchResults(
            @Query("term") CharSequence term,
            @Query("entity") String entity
    );
}
