package com.example.fitapet.retrofit.`interface`

import com.example.fitapet.retrofit.dto.getCurrentServiceDTO
import com.example.fitapet.retrofit.dto.getPetsDTO
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
    fun getPets(@Path("customerId") customerId:String):Call<getPetsDTO>

    @GET("users/{userId}/current-service")
    fun getCurrentService(@Path("userId") userId:String):Call<getCurrentServiceDTO>
}