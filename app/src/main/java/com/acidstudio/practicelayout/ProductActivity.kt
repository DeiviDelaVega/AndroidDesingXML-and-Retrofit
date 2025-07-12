package com.acidstudio.practicelayout

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.acidstudio.model.Producto
import com.acidstudio.net.ApiService
import com.acidstudio.net.ListProductResponse
import com.acidstudio.net.ProductResponse
import com.acidstudio.practicelayout.databinding.ActivityProductBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProductActivity : AppCompatActivity(){

    private lateinit var Binding : ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecycle()
        retrofit()

    }

    private fun retrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.listProducts().enqueue(object : Callback<ListProductResponse>{
            override fun onResponse(
                call: Call<ListProductResponse>,
                response: Response<ListProductResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()

                    responseBody?.let { body ->
                        val products = body.products
                        for (comment in products) {
                            Log.i("CHECK_RESPONSE", "onResponse: ${comment.id} ${comment.titulo}")
                        }
                    }
                } else {
                    Log.i("CHECK_RESPONSE", "onFailure: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<ListProductResponse>, t: Throwable) {
                Log.i("CHECK_RESPONSE", "onFailure: ${t.message}")
            }

        }
        )

    }

    val productos = listOf(
        Producto(R.drawable.auricular_item, "Smartphone", "$600"),
        Producto(R.drawable.celular_item, "Classi Watch", "$400"),
        Producto(R.drawable.auricular_item, "Smartphone", "$300"),
        Producto(R.drawable.celular_item, "Classi Watch", "$100"),
        Producto(R.drawable.auricular_item, "Smartphone", "$200"),
        Producto(R.drawable.celular_item, "Classi Watch", "$600"),
        Producto(R.drawable.auricular_item, "Smartphone", "$600"),
        Producto(R.drawable.celular_item, "Classi Watch", "$400"),
        Producto(R.drawable.auricular_item, "Smartphone", "$300"),
        Producto(R.drawable.celular_item, "Classi Watch", "$100"),
        Producto(R.drawable.auricular_item, "Smartphone", "$200"),
        Producto(R.drawable.celular_item, "Classi Watch", "$600"),
        Producto(R.drawable.auricular_item, "Smartphone", "$600"),
        Producto(R.drawable.celular_item, "Classi Watch", "$400"),
        Producto(R.drawable.auricular_item, "Smartphone", "$300"),
        Producto(R.drawable.celular_item, "Classi Watch", "$100"),
        Producto(R.drawable.auricular_item, "Smartphone", "$200"),
        Producto(R.drawable.celular_item, "Classi Watch", "$600")
    )

    fun initRecycle() {

        val adapter = MyAdapterProducts(productos)
        Binding.recyclerProducts.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false)
        Binding.recyclerProducts.adapter = adapter
    }

}
