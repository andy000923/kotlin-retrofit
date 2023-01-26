package com.umc.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.umc.test.Instance.marketplaceservice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        marketplaceservice.kotlinUsers().enqueue(object : Callback<Testlist> {
            override fun onResponse(
                call: Call<Testlist>,
                response: Response<Testlist>
            ) {
                response.body()?.let { result ->
                    Log.d("wewewe",result.toString())
                }
            }

            override fun onFailure(call: Call<Testlist>, t: Throwable) {
                Log.e("wewewe", "${t.localizedMessage}")
            }
        })
    }
}