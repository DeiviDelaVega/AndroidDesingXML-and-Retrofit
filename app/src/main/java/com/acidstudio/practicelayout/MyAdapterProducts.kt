package com.acidstudio.practicelayout

import android.content.Intent
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acidstudio.model.Producto
import com.acidstudio.practicelayout.databinding.ItemProductBinding

class MyAdapterProducts(private val producto:List<Producto>) : RecyclerView.Adapter<MyAdapterProducts.ViewHolder>(){

    class ViewHolder(private val binding : ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(producto : Producto) {
            binding.imageView2.setImageResource(producto.image)
            binding.textView10.text = producto.titulo
            binding.textView11.text = producto.precio

            val cardViewClick = binding.CardViewProduct

            val context = binding.root.context

            cardViewClick.setOnClickListener {
                val intent = Intent(context, SettingsActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder((binding))
    }

    override fun getItemCount() = producto.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind((producto[position]))
    }


}