package com.example.fitapet.retrofit.dto

data class isLikeDTO (val serviceId:Long?,
                 val customerId:Long?,
                 val isLike:String,
                 val content:String)

data class isLikeDtoNoResult(
    val isSuccess:String,
    val code:Int,
    val message:String,
)

