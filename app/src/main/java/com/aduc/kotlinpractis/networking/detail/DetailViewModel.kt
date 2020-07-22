package com.aduc.kotlinpractis.networking.detail

import android.net.DnsResolver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aduc.kotlinpractis.networking.login.LoginDataModel
import com.aduc.kotlinpractis.remote.RetroClass
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class DetailViewModel:ViewModel() {


    private var myData:MutableLiveData<List<DetailDataModel>> = MutableLiveData()
    private var error:MutableLiveData<String> = MutableLiveData()


    fun getMyData():MutableLiveData<List<DetailDataModel>>{
        return myData
    }
    fun getError():MutableLiveData<String>{
        return error
    }



    fun apiCallDetail(){
        RetroClass.instance.data()
            .enqueue(object: retrofit2.Callback<DetailResponse> {
                override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                    error.value = t.message
                }

                override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {

                    response.body()?.data?.let {
                        myData.value = it
                    }
                }
            })
    }
}