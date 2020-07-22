package com.aduc.kotlinpractis.networking.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aduc.kotlinpractis.remote.RetroClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel : ViewModel() {

    var username = MutableLiveData<String>()
    private val loginResponseData: MutableLiveData<LoginDataModel> = MutableLiveData()
    private val successData: MutableLiveData<String>  = MutableLiveData()


    fun getLoginResponseData(): MutableLiveData<LoginDataModel>? {
        return loginResponseData
    }

    fun getsuccessData(): MutableLiveData<String>? {
        return successData
    }

    fun apiCallLogin(email:String){
        RetroClass.instance.userLogin(email)
            .enqueue(object: Callback<LoginDataModel> {
                override fun onFailure(call: Call<LoginDataModel>, t: Throwable) {
                    successData.value = t.message
                }

                override fun onResponse(call: Call<LoginDataModel>, response: Response<LoginDataModel>) {
                   loginResponseData.value = response.body()
                    successData.value = response.body()?.message
                }
            })
    }

}