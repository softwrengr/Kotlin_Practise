package com.aduc.kotlinpractis.dagger

import android.util.Log
import javax.inject.Inject

class AeroPlane {

    lateinit var engine: EngineInterface
    lateinit var wheel: Wheel

    @Inject
    constructor(engine: EngineInterface,wheel: Wheel){
        this.engine = engine
        this.wheel = wheel
    }


    fun checkStatus(){
        Log.d("status", engine.checkEngine() + " and " + wheel.checkWheels)
    }
}