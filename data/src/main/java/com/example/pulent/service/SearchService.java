package com.example.pulent.service;

import com.example.pulent.dto.ResultDTO;
import retrofit2.Callback;

public interface SearchService {
    void searchForText(String text, Callback<ResultDTO> callback);
}
