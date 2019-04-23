package com.example.pulent.mvp.view

import com.example.pulent.dto.SongDTO

interface MainView {
    fun loadingIndicatorVisibility(visibility : Boolean)
    fun performSearch(text : String)
    fun retrieveSongList(songs: MutableList<SongDTO>)
}