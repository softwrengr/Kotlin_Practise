package com.aduc.kotlinpractis.singeltion

open class ClassA {
    open fun printVarName() {
        print("I am in classA printVarName")
    }

    init {
        println("I am in init of ClassA")
    }
}