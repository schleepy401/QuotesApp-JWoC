package com.jwoc.quotesapp.data.api

import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {

    @GET("/")
    suspend fun getQuotes() : Response<ArrayList<Quote>>
}