package com.example.fitapet.retrofit.dto

data class getPetsDTO(
    val petId:Int,
    val petName:String,
    val petType:String,
    val petBirth:String,
    val petSize:String,
    val petSex:String,
    val petAge:Int,
    val registrationType:String,
    val isNeutralize:String
)
