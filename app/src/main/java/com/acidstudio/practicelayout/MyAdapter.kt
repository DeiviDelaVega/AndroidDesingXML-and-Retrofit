package com.acidstudio.practicelayout

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acidstudio.net.UserResponse
import com.acidstudio.practicelayout.databinding.ItemNoticeBinding
import com.bumptech.glide.Glide

class MyAdapter() : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var users: MutableList<UserResponse> = mutableListOf()

    fun addUser(user: UserResponse) {
        users.add(user)
        notifyItemInserted(users.size - 1)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoticeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind((users[position]))
    }

    class ViewHolder(private val binding: ItemNoticeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserResponse) {

            val imageView = binding.image

            val context = binding.root.context

            Glide.with(context).load(user.image).into(imageView);
            binding.ago.text = user.universidad
            binding.textView11.text = user.nombre
            binding.textView12.text = user.apellido

            val cardViewClick = binding.CardView

            cardViewClick.setOnClickListener {
                val intent = Intent(context, ProductActivity::class.java)
                context.startActivity(intent)
            }
        }
    }


}