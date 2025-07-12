package com.acidstudio.practicelayout

import android.content.Intent
import android.sax.StartElementListener
import android.util.Log
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.acidstudio.model.Articulo
import com.acidstudio.practicelayout.databinding.ActivityNoticeBinding
import com.acidstudio.practicelayout.databinding.ItemNoticeBinding

class MyAdapter(private val articulo:List<Articulo>) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    class ViewHolder(private val binding: ItemNoticeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(articulo: Articulo) {
            Log.e("ITEM VIEW HOLDER",articulo.toString())
            binding.image.setImageResource(articulo.imagen)
            binding.ago.text = articulo.hora
            binding.textView11.text = articulo.titulo
            binding.textView12.text = articulo.descripcion
            val cardViewClick = binding.CardView

            val context = binding.root.context

            cardViewClick.setOnClickListener {
                val intent = Intent(context, ProductActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val binding = ItemNoticeBinding.inflate(
           LayoutInflater.from(parent.context),
           parent,
           false
       )
        return ViewHolder(binding)
    }

    override fun getItemCount() = articulo.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articulo[position])
    }


}