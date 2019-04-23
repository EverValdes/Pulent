package com.example.pulent.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pulent.R
import com.example.pulent.di.component.DaggerMainComponent
import com.example.pulent.di.module.MainModule
import com.example.pulent.mvp.presenter.MainPresenter
import com.example.pulent.mvp.view.MainView
import com.example.pulent.ui.adapter.SongListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import models.Song
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {


    @Inject
    lateinit var presenter : MainPresenter

    private lateinit var adapter: RecyclerView.Adapter<SongListAdapter.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mainComponent = DaggerMainComponent.builder().mainModule(MainModule(this)).build()
        mainComponent.injectTo(this)

        searchButton.setOnClickListener { presenter.searchButtonClicked(searchTextInputEditText.text.toString()) }
    }

    override fun loadingIndicatorVisibility(visibility : Boolean) {
        if (visibility) {
            loadingIndicator.visibility = View.VISIBLE
            return
        }
        loadingIndicator.visibility = View.GONE
    }

    override fun retrieveSongList(songs: MutableList<Song>) {
        //We need a transformer for DTO to entity
        adapter = SongListAdapter(songs)
        songRecycler.adapter = adapter
    }
}