package com.example.pulent.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pulent.R
import com.example.pulent.di.component.DaggerMainComponent
import com.example.pulent.di.module.MainModule
import com.example.pulent.mvp.presenter.MainPresenter
import com.example.pulent.mvp.presenter.retrieve.JsonReader
import com.example.pulent.mvp.view.MainView
import com.example.pulent.ui.adapter.SongListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import models.Song
import java.util.ArrayList
import javax.inject.Inject

const val ENDPOINT = "https://itunes.apple.com/search?term=in+utero&mediaType=music&limit=20"
const val URL = "https://itunes.apple.com/search?term=Michael+Jackson"
class MainActivity : AppCompatActivity(), MainView, JsonReader.SongRetriver {


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

    override fun performSearch(text : String) {
        runOnUiThread {
            JsonReader(this).execute(text)
        }
    }

    override fun retrieveSongs(songs : ArrayList<Song>) {
        adapter = SongListAdapter(songs)
        songRecycler.adapter = adapter
        loadingIndicatorVisibility(false)
    }
}