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

    @GET("customers/{customerId}/status")
    fun getStatus(
        @Path("customerId") customerId: Long?
    ) : Call<getStatus>

    @GET("customer/{customerId}/address")
    fun getAddr(
        @Path("customerId") customerId: Long?
    ) : Call<getAddr>

    @GET("customer/{customerId}/pets")
    fun getPets(@Path("customerId") customerId:Long?):Call<getPets>

    @GET("users/{userId}/current-service")
    fun getCurrentService(@Path("userId") userId:Long?):Call<getCurrentServiceDTO>

    @GET("customers/{customerId}/hasid")
    fun getHasId(@Path("customerId") kakaoUserId:Long?): Call<getCurrentServiceDTO>

    @GET("customer/{customerId}")
    fun getSimple(
        @Path("customerId") customerId: Long?
    ) : Call<getUser>

    @GET("customers/{customerId}/detail")
    fun getDetail(
        @Path("customerId") customerId: Long?
    ) : Call<getDetail>

    @GET("customer/{customerId}/bookmarks")
    fun getBmark(
        @Path("customerId") customerId: Long?
    ) : Call<getBmark>

    @GET("users/{userId}/petsitters/same-location")
    fun searchPsitter(
        @Path("userId") userId: Long?,
        @QueryMap option : Map<String, String>,
        //@Query("sex") sex: String,
        //@Query("isWalkable_YN") isWalkable_YN: String
    ) : Call<searchPsitter>

    @PATCH("customer/{customerId}/userInfo")
    fun editInfo(
        @Path("customerId") customerId: Long?,
        @Body editCpl: bodyClass,
        //@Body tel: String, //주소 보내는 Body 더 필요
        //@Body addr: String
    ) : Call<editInfo>

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

    @PATCH("service/is-like")
    fun service_is_like(
        @Body isLikeDto: isLikeDTO,
    ) : Call<isLikeDtoNoResult>

    @POST("customer/{customerId}/pets")
    fun registerPet(
        @Path("customerId")customerId: Long?,
        @Body registerPet: registerPetDTO
    ): Call<registerPetDtoNoResult>

    @POST("customer/{customerId}/friend")
    fun addFriend(
        @Path("customerId")customerId: Long?,
        @Body friendEmail: addFriendDTO
    )

    @GET("customers/{customerId}/diagnose")
    fun getDiagnosis(
        @Path("customerId") customerId: Long?
    ) : Call<getDiagnosis>

//    @GET("customer/{customerId}/pets")
//    fun getPets(@Path("customerId")customerId: Long?):Call<getPets>

    //    @POST("consumer/user")
//    fun test1(
//        @Body dogs:Dogs
//    ): Call<Data>
//    //Call<>
}