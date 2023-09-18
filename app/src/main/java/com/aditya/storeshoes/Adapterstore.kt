package com.aditya.storeshoes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aditya.storeshoes.databinding.ItemStoreBinding
import com.bumptech.glide.Glide


class Adapterstore(
    private val onClick: (Store) -> Unit,
    private val onLongClick: (Store) -> Unit
) : ListAdapter<Store, Adapterstore.ViewHOlder>(DIF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHOlder {
        val binding = ItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHOlder(binding)

    }

    override fun onBindViewHolder(holder: ViewHOlder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(getItem(position))

    }

    inner class ViewHOlder(
        private val binding: ItemStoreBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Store) {
            binding.tvPrice.text = data.harga.toInt().toString()
            Glide.with(itemView.context)
                .load(data.image)
                .error(android.R.color.darker_gray)
                .into(binding.imgStore)
            binding.tvTitle.text = data.nama.toString()
            binding.cView.setOnClickListener {
                onClick(data)
            }
            binding.cView.setOnLongClickListener {
                onLongClick(data)
                return@setOnLongClickListener true
            }
        }
    }


    companion object {
        val DIF_CALLBACK: DiffUtil.ItemCallback<Store> =
            object : DiffUtil.ItemCallback<Store>() {
                override fun areItemsTheSame(oldItem: Store, newItem: Store): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldItem: Store, newItem: Store): Boolean {
                    return oldItem == newItem
                }

            }
    }
}
