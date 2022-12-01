package com.example.fitapet.retrofit.dto

data class addFriendDTO(
    val email:String?
)
data class addFriendDtoNoResult(
    val isSuccess:String,
    val code:Int,
    val message:String
)