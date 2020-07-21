package com.aduc.kotlinpractis.dagger

import javax.inject.Inject

class Engine {
    lateinit var checkEngine:String

    @Inject
    constructor(){
     checkEngine = "Both engines are okay"
    }

    fun engineStatus():String{
        return checkEngine
    }
}