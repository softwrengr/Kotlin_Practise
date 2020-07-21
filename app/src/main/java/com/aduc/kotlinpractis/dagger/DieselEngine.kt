package com.aduc.kotlinpractis.dagger

import javax.inject.Inject

class DieselEngine:EngineInterface{

    @Inject
    constructor(){

    }

    override fun checkEngine(): String {
      return  "this is diesel engine"
    }

}