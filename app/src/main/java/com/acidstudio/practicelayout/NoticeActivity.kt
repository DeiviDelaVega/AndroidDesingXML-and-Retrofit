package com.acidstudio.practicelayout

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.acidstudio.net.ApiServiceUser
import com.acidstudio.net.ListUserResponse
import com.acidstudio.practicelayout.databinding.ActivityNoticeBinding
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Callback
import retrofit2.Response

class NoticeActivity : AppCompatActivity() {


    private lateinit var Binding: ActivityNoticeBinding

    private val adapter =  MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(Binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        InitRecycle()
        retrofit()
    }

    private fun retrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServiceUser::class.java)

        retrofit.listUser().enqueue(object : Callback<ListUserResponse> {
            override fun onResponse(
                call: Call<ListUserResponse>,
                response: Response<ListUserResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    Log.i("CHECK_RESPONSE", "onResponse: $responseBody")
                    responseBody?.let { body ->
                        val users = body.user

                        users.forEach { user ->
                            adapter.addUser(user)
                        }
                    }
                } else {
                    Log.i("CHECK_RESPONSE", "onFailure: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<ListUserResponse>, t: Throwable) {
                Log.i("CHECK_RESPONSE", "onFailure: ${t.message}")
            }
        }
        )
    }

    fun InitRecycle() {
        Binding.recyclerUser.layoutManager =
            LinearLayoutManager(this)
        Binding.recyclerUser.adapter = adapter
    }


}
