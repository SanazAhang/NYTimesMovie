package com.example.nytimesmovie.domain.usecase

interface BaseUseCase<inPut, outPut> {

    suspend fun execute(input: inPut): outPut
}