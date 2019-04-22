package com.example.pulent.di.component

import com.example.pulent.di.module.MainModule
import com.example.pulent.ui.presenter.MainPresenter
import com.example.pulent.ui.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    MainModule::class])
interface MainComponent {
    fun injectTo(activity : MainActivity)
    fun injectTo(presenter: MainPresenter)
}