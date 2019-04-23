package com.example.pulent.di.module

import com.example.pulent.mvp.view.MainView
import com.example.pulent.mvp.presenter.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    var view : MainView
    constructor(view : MainView) {
        this.view = view
    }
    @Provides
    fun provideMainView() : MainView {return this.view}

    @Provides
    fun providePresenter() : MainPresenter { return MainPresenter(view)}
}