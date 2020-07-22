package com.aduc.kotlinpractis.innerClass

import com.aduc.kotlinpractis.MainActivity
import java.lang.ref.WeakReference


class OuterClass {

    var x = 10;
    var  y = 10;


    inner class InnerClass() {

        private val mainActivity: WeakReference<OuterClass>? = null
        var z = 20

        fun getTotal():Int{
            return x + y + z
        }
    }
}