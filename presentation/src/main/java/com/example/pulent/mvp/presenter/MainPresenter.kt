package com.example.pulent.mvp.presenter

import com.example.pulent.mvp.presenter.retrieve.JsonReader
import java.util.concurrent.Executors
import com.example.pulent.mvp.view.MainView
import com.google.gson.Gson
import models.Song
import java.net.URL


class MainPresenter(var view: MainView?) {
    lateinit var objectList: ArrayList<kotlin.Any>

    fun searchButtonClicked(searchText : String) {
        if (searchText.isNotEmpty()) {
            view?.loadingIndicatorVisibility(true)
            performSearch(searchText)
        } else {
            view?.loadingIndicatorVisibility(false)
        }
    }

    fun performSearch(text : String) {
        view?.performSearch(text)
    }
}