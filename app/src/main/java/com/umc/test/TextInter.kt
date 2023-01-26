package com.umc.test

import retrofit2.Call
import retrofit2.http.GET

interface TextInter {
    @GET()
    fun kotlinUsers() : Call<Testlist>
}