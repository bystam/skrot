package com.decubate.skrot.api

import com.decubate.skrot.api.models.APIHomeScreenData
import com.decubate.skrot.api.models.APIUserId
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header


interface SkrotService {
    @GET("home")
    fun getHomeScreen(@Header("X-User-Id") userId: String): Single<APIHomeScreenData>

    @GET("register")
    fun registerNewUser(): Single<APIUserId>
}

var retrofit = Retrofit.Builder()
    .baseUrl("https://skrot.herokuapp.com/")
    .client(
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BASIC) })
            .build()
    )
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

var service = retrofit.create<SkrotService>(SkrotService::class.java)