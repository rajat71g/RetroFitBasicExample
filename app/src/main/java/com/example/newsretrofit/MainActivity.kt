package com.example.newsretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news: Call<News> = NewsService.newsInstance.getHeadLine("in",1)
        news.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val r: News? = response.body()
                if(r != null){
                    Log.d(TAG, "onResponse: $r")
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d(TAG, "onFailure: Failure ")
            }
        })
    }
}