package com.aduc.kotlinpractis.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClass {
    val BASE_URL = "http://5.101.139.188:83/"
    // val BASE_URL = "http://kuedoz-api-2.kuedoz.com/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                //.addHeader("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhYnVsbGFoIiwiZXhwIjoxNTk2ODYwNTY1fQ.9H5arR5-7wF_AwqMNS0fxTczT0fOEYAvY730IBIycxc")
                .method(original.method, original.body)

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: ApiInterface by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(ApiInterface::class.java)
    }
}