package com.aduc.kotlinpractis.networking.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aduc.kotlinpractis.R
import com.aduc.kotlinpractis.adapters.DetailAdapter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: DetailAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        viewModel.apiCallDetail()

        viewModel.getMyData().observe(this, Observer {
            Toast.makeText(this,it.get(0).address,Toast.LENGTH_LONG).show()
            recyclerAdapter = DetailAdapter()
            recyclerAdapter.setItems(it)
            recyler_view.adapter = recyclerAdapter

        })

        viewModel.getError().observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_LONG).show()
        })
    }
}