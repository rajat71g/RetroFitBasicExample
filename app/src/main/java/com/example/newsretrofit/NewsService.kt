package com.example.newsretrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/everything?q=tesla&from=2021-04-23&sortBy=publishedAt&apiKey=d08858a72b93433c88ddbfe686f9a031
//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=d08858a72b93433c88ddbfe686f9a031
const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "d08858a72b93433c88ddbfe686f9a031"
interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLine(@Query("country") country: String, @Query("page") page: Int): Call<News>
}

object NewsService{
     val newsInstance: NewsInterface
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}