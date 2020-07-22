package com.aduc.kotlinpractis.networking.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aduc.kotlinpractis.R
import kotlinx.android.synthetic.main.activity_loginn.*


class LoginnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginn)


        val loinViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        btn_login.setOnClickListener {
            loinViewModel.apiCallLogin("softwrengr@gmail.com")
            text_success.text = "loading..."
        }

        loinViewModel.getsuccessData()?.observe(this, Observer {
            text_success.text = it
        })
    }


}