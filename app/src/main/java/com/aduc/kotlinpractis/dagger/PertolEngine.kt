package com.aduc.kotlinpractis.dagger

import javax.inject.Inject

class PertolEngine:EngineInterface {

    @Inject
    constructor(){

    }

    override fun checkEngine(): String {
        return "this is petrol engine"
    }


}