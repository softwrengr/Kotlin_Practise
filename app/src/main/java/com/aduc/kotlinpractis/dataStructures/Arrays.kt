package com.aduc.kotlinpractis.dataStructures

class Arrays {

    lateinit var myArrays:Array<String>
    lateinit var myArrayList:ArrayList<String>

    constructor(){
        myArrays = Array(4){""}
        myArrays[0] = "Abdullah"
        myArrays[1] = "Waseem"
        myArrays[2] = "Merlin"

        myArrayList = ArrayList()
        myArrayList.add("Dubai")
        myArrayList.add("Abu dhabi")
        myArrayList.add("Ajman")

    }

    fun getArrays(){
        for(i in 0 until myArrays.size){
            println("Name $i: ${myArrays[i]}" )
        }
    }

    fun getArrayList(){
        for (i in 0 until  myArrayList.size){
            println("Location $i ${myArrayList[i]}")
        }
    }
}