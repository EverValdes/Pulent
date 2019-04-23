package com.example.pulent.di.module

import com.example.pulent.mvp.strategegy.SearchStrategy
import com.example.pulent.service.SearchService
import com.example.pulent.service.SearchServiceImpl
import dagger.Module
import dagger.Provides
import models.MainUseCase
import javax.inject.Singleton

@Module
class SearchModule() {

    @Provides
    @Singleton
    fun provideSearchStrategy(mainUseCase: MainUseCase): SearchStrategy {
        return SearchStrategy(mainUseCase)
    }
}