package com.aduc.kotlinpractis.dagger

import com.aduc.kotlinpractis.MainActivity
import dagger.Component
import javax.inject.Inject

@Component(modules = [EngineModules::class])
interface PlaneComponent {

    fun getPlane():AeroPlane

    fun Inject(mainActivity: MainActivity)
}