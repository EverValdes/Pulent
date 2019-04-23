package com.example.pulent.mvp.strategegy

import com.example.pulent.dto.ResultDTO
import models.MainUseCase
import retrofit2.Callback
import javax.inject.Inject

class SearchStrategy {

    @Inject
    lateinit var mainUseCase : MainUseCase

    constructor(mainUseCase : MainUseCase) {
        this.mainUseCase = mainUseCase
    }

    fun execute(text : String, callback : Callback<ResultDTO>) {
        mainUseCase.searchForText(text, callback)
    }
}