package com.example.fitapet.retrofit.dto

data class registerPetDTO(
    val pet:Pet,
    val customerId:String,
    val hospitalName:String,
    val hospitalTel: String,
    val survey:MutableList<Int>

)

data class Pet(
    val petName:String,
    val petType:String,
    val petSpecies:String,
    val petBirth:String,
    val petSize:String,
    val petSex:String,
    val petAge:Int,
    val profileImg:String,
    val registrationType:String,
    val isNeutralize:String
)

data class registerPetDtoNoResult(
    val isSuccess:String,
    val code:Int,
    val message:String,
)
