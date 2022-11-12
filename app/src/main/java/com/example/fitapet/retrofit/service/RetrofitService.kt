package com.example.fitapet.retrofit.service

import com.example.fitapet.retrofit.dto.*
import retrofit2.http.*
import retrofit2.Call

interface RetrofitService {
    //    @POST("consumer/user")
//    fun test1(
//        @Body dogs:Dogs
//    ): Call<Data>
//    //Call<>
//
//
//    @GET("posts/{page}")
//    fun getUserPage(@Path("page") page: String): Call<User>

    @GET("customer/{customerId}/pets")
    fun getPets(@Path("customerId") customerId:Long?):Call<getPets>

    @GET("users/{userId}/current-service")
    fun getCurrentService(@Path("userId") userId:Long?):Call<getCurrentServiceDTO>

    @GET("customers/{customerId}/hasid")
    fun getHasId(@Path("customerId") kakaoUserId:Long?): Call<getCurrentServiceDTO>

    @POST("customer/user")
    fun signUp(
        @Body kakaoUser:KakaoUser
    ): Call<getCurrentServiceDtoNoResult>

    @GET("customer/{customerId}/friends")
    fun getFriends(@Path("customerId")customerId: Long?): Call<FriendDTO>

    @GET("reviews")
    fun getRevies():Call<ReviewDTO>

    @GET("reviews/detail")
    fun getReviewDetail():Call<ReviewDetailDTO>
//    @GET("customer/{customerId}/pets")
//    fun getPets(@Path("customerId")customerId: Long?):Call<getPets>

    //    @POST("consumer/user")
//    fun test1(
//        @Body dogs:Dogs
//    ): Call<Data>
//    //Call<>
}