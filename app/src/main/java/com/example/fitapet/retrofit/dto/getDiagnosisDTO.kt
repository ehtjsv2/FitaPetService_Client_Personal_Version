package com.example.fitapet.retrofit.dto

data class getDiagnosis (
    val isSuccess: String,
    val code: Int,
    val message: String,
    val result: List<DocReview>
)

data class DocReview (
    val veterinarianName: String,
    val veterinarianImgUrl: String,
    val diagnose: String
)