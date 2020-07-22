package com.aduc.kotlinpractis.networking.detail

data class DetailResponse(var success:Boolean, var status:Int, var message:String,var data:List<DetailDataModel>) {
}