package com.example.pulent.mvp.presenter

import com.example.pulent.BuildConfig.ITUNES_URL
import com.example.pulent.BuildConfig.ITUNES_URL_DECORATION
import com.example.pulent.dto.ResultDTO
import com.example.pulent.mvp.view.MainView
import models.MainUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var view: MainView?) {



    fun searchButtonClicked(searchText : String) {
        if (searchText.isNotEmpty()) {
            view?.loadingIndicatorVisibility(true)
            performSearch(searchText)
        } else {
            view?.loadingIndicatorVisibility(false)
        }
    }

    fun performSearch(text : String) {
        val search = ITUNES_URL + text + ITUNES_URL_DECORATION
        //view?.performSearch(search)

        val main = MainUseCase()

        main.searchForText(text, object : Callback<ResultDTO> {
            override fun onResponse(call: Call<ResultDTO>, response: Response<ResultDTO>) {
                if (response.isSuccessful && response.body() != null) {
                    view?.loadingIndicatorVisibility(false)
                    val songDTOList = response.body()!!.songDTOList
                    view?.retrieveSongList(songDTOList)
                }
            }

            override fun onFailure(call: Call<ResultDTO>, t: Throwable) {
                //TODO: Handle error scenarios
            }
        })

    }


}