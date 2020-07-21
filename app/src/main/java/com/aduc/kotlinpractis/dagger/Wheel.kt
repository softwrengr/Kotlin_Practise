package com.aduc.kotlinpractis.dagger

import javax.inject.Inject

class Wheel {
    lateinit var checkWheels:String
    @Inject
    constructor(){
       checkWheels = "All wheel are fine"
    }

    fun checkWheelStauts():String{
        return checkWheels
    }
}