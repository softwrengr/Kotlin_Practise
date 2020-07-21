package com.aduc.kotlinpractis.dagger

import dagger.Module
import dagger.Provides

@Module
class EngineModules {

    @Provides
    fun providesPetrolEngine(pertolEngine: PertolEngine):EngineInterface{
        return pertolEngine
    }

//    @Provides
//    fun dieselPetrolEngine(pertolEngine: DieselEngine):EngineInterface{
//        return pertolEngine
//    }
}