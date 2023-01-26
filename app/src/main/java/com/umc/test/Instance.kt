package com.umc.test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Instance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("http://pick-cle.shop/api")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val marketplaceservice : TextInter by lazy {
        retrofit.create(TextInter::class.java)
    }
}