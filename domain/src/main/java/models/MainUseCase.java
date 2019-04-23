package models;

import com.example.pulent.dto.ResultDTO;

import com.example.pulent.service.SearchServiceImpl;

import retrofit2.Callback;


public class MainUseCase {

    public void searchForText(String text, Callback<ResultDTO> callback) {
        SearchServiceImpl searchServiceImpl = new SearchServiceImpl();
        searchServiceImpl.searchForText(text, callback);
    }


}
