package com.example.fitapet.retrofit.dto

data class getBmark(
    val isSuccess: String,
    val code: Int,
    val message: String,
    val result: List<Bookmark>
)

data class Bookmark(
    val petSitterId: Int,
    val petSitterProfileImg: String,
    val petSitterName: String,
    val sex: String,
    val age: String,
    val careType: String,
    val isAgreeSharingLocation_YN: String,
    val isAgreeToFilm_YN: String,
    val isPossibleCareOldPet_YN: String,
    val isWalkable_YN: String
)