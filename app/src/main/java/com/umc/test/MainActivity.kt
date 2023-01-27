package com.umc.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.umc.test.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val api = APIS.create();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.postbutton.setOnClickListener {
            val data = PostModel(binding.idedt.text.toString(),binding.nickedt.text.toString())
            api.post_users(data).enqueue(object : Callback<PostResult> {
                override fun onResponse(call: Call<PostResult>, response: Response<PostResult>) {
                    Log.d("log",response.toString())

                    Log.d("log",response.body().toString())
                    if(!response.body().toString().isEmpty())
                        binding.text.setText(response.body().toString())
                    Log.d("log",response.body().toString())
                }
                override fun onFailure(call: Call<PostResult>, t: Throwable) {
                    // 실패
                    Log.d("log",t.message.toString())
                    Log.d("log","fail")
                }
            })
        }

    }
}