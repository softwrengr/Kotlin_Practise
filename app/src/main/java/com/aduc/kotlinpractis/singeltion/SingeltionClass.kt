package com.aduc.kotlinpractis.singeltion

object  SingeltionClass:ClassA(){

    init {
        println("Singleton class invoked.")
    }
    

    var variableName = "I am Var of singelton overiding printVarName of ClassA"
    override fun printVarName() {
        println(variableName)
    }

}