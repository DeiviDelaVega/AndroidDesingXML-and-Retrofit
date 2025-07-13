package com.acidstudio.practicelayout

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acidstudio.net.ProductResponse
import com.acidstudio.practicelayout.databinding.ItemProductBinding
import com.bumptech.glide.Glide


class MyAdapterProducts() : RecyclerView.Adapter<MyAdapterProducts.ViewHolder>(){

    private var products: MutableList<ProductResponse> = mutableListOf()

    fun addProduct(product: ProductResponse) {
        products.add(product)
        notifyItemInserted(products.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder((binding))
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind((products[position]))
    }

    class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductResponse) {

            val imageView = binding.imageView2

            val context = binding.root.context

            Glide.with(context).load(product.imagen).into(imageView)
            binding.textView10.text = product.titulo
            binding.textView11.text = product.precio.toString()

            val cardViewClick = binding.CardViewProduct

            cardViewClick.setOnClickListener {
                val intent = Intent(context, SettingsActivity::class.java)
                context.startActivity(intent)
            }
        }
    }


}