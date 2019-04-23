package com.example.pulent.di.component

import com.example.pulent.di.module.MainModule
import com.example.pulent.di.module.SearchModule
import com.example.pulent.mvp.presenter.MainPresenter
import com.example.pulent.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    MainModule::class,
    SearchModule::class])
interface MainComponent {
    fun injectTo(activity : MainActivity)
    fun injectTo(presenter: MainPresenter)
}