package com.aduc.kotlinpractis.innerClass

class OuterClass {

    var x = 10;
    var  y = 10;


    inner class InnerClass() {
        var z = 20

        fun getTotal():Int{
            return x + y + z
        }
    }
}