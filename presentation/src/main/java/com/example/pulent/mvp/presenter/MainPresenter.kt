package com.example.pulent.mvp.presenter

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

    }
}