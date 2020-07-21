package com.aduc.kotlinpractis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aduc.kotlinpractis.dataStructures.Arrays
import com.aduc.kotlinpractis.dagger.AeroPlane
import com.aduc.kotlinpractis.dagger.DaggerPlaneComponent
import com.aduc.kotlinpractis.innerClass.OuterClass
import com.aduc.kotlinpractis.interfaces.Car
import com.aduc.kotlinpractis.singeltion.ChildClass
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivity : AppCompatActivity(){

    @Inject
    lateinit var aeroPlane: AeroPlane

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var planeComponent = DaggerPlaneComponent.create()
        planeComponent.Inject(this)
        aeroPlane.checkStatus()

        //inner class
        var inner = OuterClass().InnerClass()
        System.out.println(inner.getTotal())

        //annonymous class
        var car : Car = object :Car{
            override fun getCar() {
                Log.d("check","this is BMW")
            }
        }
        car.getCar()

        //array and list
        var oneDimensionArray = Arrays()
        oneDimensionArray.getArrays()
        oneDimensionArray.getArrayList()

        //singeltion class
        var classObject = ChildClass()

        button.setOnClickListener {
          CoroutineScope(IO).launch {
              fakeApiRequest()
          }
        }

    }


    private fun setNewText(input:String){
        val newText = text.text.toString() + "\n$input"
        text.text = newText
    }

    private suspend fun setValueOnMainThread(string: String){
         withContext(Main){
           setNewText(string)
         }
    }

    private suspend fun fakeApiRequest() {
        logThread("fakeApiRequest")

        val result1 = getResult1FromApi() // wait until job is done

        if ( result1.equals("Result #1")) {

            setValueOnMainThread("Got $result1")

            val result2 = getResult2FromApi() // wait until job is done

            if (result2.equals("Result #2")) {
                setValueOnMainThread("Got $result2")
            } else {
                setValueOnMainThread("Couldn't get Result #2")
            }
        } else {
            setValueOnMainThread("Couldn't get Result #1")
        }
    }


    private suspend fun getResult1FromApi(): String {
        logThread("getResult1FromApi")
        delay(1000) // Does not block thread. Just suspends the coroutine inside the thread
        return "Result #1"
    }

    private suspend fun getResult2FromApi(): String {
        logThread("getResult2FromApi")
        delay(1000)
        return "Result #2"
    }

    private fun logThread(methodName: String){
        println("debug: ${methodName}: ${Thread.currentThread().name}")
    }


}