package com.aduc.kotlinpractis.remote

import com.aduc.kotlinpractis.networking.detail.DetailDataModel
import com.aduc.kotlinpractis.networking.detail.DetailResponse
import com.aduc.kotlinpractis.networking.login.LoginDataModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {


    @FormUrlEncoded
    @POST("api/Login")
    fun userLogin(@Field("Email") email:String): Call<LoginDataModel>


    @GET("api/AllEvents")
    fun data(): Call<DetailResponse>
}