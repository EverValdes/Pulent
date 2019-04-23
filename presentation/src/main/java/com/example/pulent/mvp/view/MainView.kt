package com.example.pulent.mvp.view

interface MainView {
    fun loadingIndicatorVisibility(visibility : Boolean)
    fun performSearch(text : String)
}