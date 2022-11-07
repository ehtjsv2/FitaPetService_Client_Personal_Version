package com.example.fitapet.retrofit.dto

data class getCurrentServiceDTO (
    val isSuccess:String,
    val code:Int,
    val message:String,
    val result:currentDTO
    )

data class currentDTO(
    val petSitterName: String,
    val category: String,
    val planStartTime: String,
    val planEndTime: String,
    val customerRequestContent: String,
    val pets:List<Pets>
)

