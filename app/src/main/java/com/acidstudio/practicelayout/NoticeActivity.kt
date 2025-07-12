package com.acidstudio.practicelayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.acidstudio.model.Articulo
import com.acidstudio.practicelayout.databinding.ActivityNoticeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoticeActivity : AppCompatActivity() {


    private lateinit var Binding: ActivityNoticeBinding

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
    }

    val articulos = listOf(
        Articulo(R.drawable.retrato_hombre, "3h ago", "Monterrico Polo Aparts", "lorem1"),
        Articulo(R.drawable.retrato_hombre, "4h ago", "Monterrico Polo Aparts2", "lorem2"),
        Articulo(R.drawable.retrato_hombre, "6h ago", "Monterrico Polo Aparts3", "lorem3"),
        Articulo(R.drawable.retrato_hombre, "5h ago", "Monterrico Polo Aparts4", "lorem4")

    )

    fun InitRecycle() {

        val adapter = MyAdapter(articulos)
        Binding.recyclerView.layoutManager = LinearLayoutManager(this) //Siempre se pone para reconocer que tipo de layout es
        Binding.recyclerView.adapter = adapter
    }




}