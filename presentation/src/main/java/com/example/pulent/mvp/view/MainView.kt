package com.example.pulent.mvp.view

import models.Song

interface MainView {
    fun loadingIndicatorVisibility(visibility : Boolean)
    fun retrieveSongList(songs: MutableList<Song>)
}