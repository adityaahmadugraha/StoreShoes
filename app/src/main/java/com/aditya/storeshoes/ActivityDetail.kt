package com.aditya.storeshoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditya.storeshoes.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class ActivityDetail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val id = intent.getStringExtra("id").toString()
        val nama = intent.getStringExtra("nama").toString()
        val nomor = intent.getStringExtra("nomor").toString()
        val warna = intent.getStringExtra("warna").toString()
        val harga = intent.getStringExtra("harga").toString()
        val image = intent.getStringExtra("image").toString()

        val imgDetail = binding.imgDetail
        Glide.with(this)
            .load(image)
            .into(imgDetail);

//        binding.tvDetail.text = nama
//        binding.tvPrice.text = harga


        binding.imgBack.setOnClickListener {
            val intent = Intent(this@ActivityDetail, MainActivity::class.java)
            startActivity(intent)
        }

//            binding.btnBuy.setOnClickListener {
//                val intent = Intent(this@ActivityDetail, MainActivity::class.java)
//                startActivity(intent)
//        }
    }


}