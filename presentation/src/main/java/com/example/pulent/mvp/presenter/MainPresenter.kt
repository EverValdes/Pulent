package com.example.pulent.mvp.presenter

import com.example.pulent.BuildConfig.ITUNES_URL
import com.example.pulent.BuildConfig.ITUNES_URL_DECORATION
import com.example.pulent.dto.ResultDTO
import com.example.pulent.dto.SongDTO
import com.example.pulent.mvp.strategegy.SearchStrategy
import com.example.pulent.mvp.view.MainView
import com.example.pulent.transformer.SongTransformer
import models.Song
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter(var view: MainView?) {

    @Inject
    lateinit var main : SearchStrategy

    fun searchButtonClicked(searchText : String) {
        if (searchText.isNotEmpty()) {
            view?.loadingIndicatorVisibility(true)
            performSearch(searchText)
        } else {
            view?.loadingIndicatorVisibility(false)
        }
    }

    fun performSearch(text : String) {
        main.execute(text, object : Callback<ResultDTO> {
            override fun onResponse(call: Call<ResultDTO>, response: Response<ResultDTO>) {
                if (response.isSuccessful && response.body() != null) {
                    view?.loadingIndicatorVisibility(false)
                    val songDTOList = response.body()!!.songDTOList
                    val songTransformer = SongTransformer()
                    songTransformer.transformDTOList(songDTOList)

                    view?.retrieveSongList(songTransformer.transformDTOList(songDTOList) as MutableList<Song>)
                }
            }

            override fun onFailure(call: Call<ResultDTO>, t: Throwable) {
                //TODO: Handle error scenarios
            }
        })

    }


}