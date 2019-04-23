package com.example.pulent.mvp.presenter

import com.example.pulent.BuildConfig.ITUNES_URL
import com.example.pulent.BuildConfig.ITUNES_URL_DECORATION
import com.example.pulent.mvp.view.MainView

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
        view?.performSearch(search)
    }
}