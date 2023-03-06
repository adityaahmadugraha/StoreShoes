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


        val id = intent.getIntExtra("id",0).toString()
        val nama = intent.getStringExtra("nama").toString()
        val nomor = intent.getIntExtra("nomor",0).toString()
        val warna = intent.getStringExtra("warna").toString()
        val harga = intent.getIntExtra("harga", 0).toString()
        val image = intent.getStringExtra("image").toString()

        val imgDetail = binding.imgDetail
        Glide.with(this)
            .load(image)
            .into(imgDetail);

        binding.tvDetail.text = nama
        binding.tvPrice.text = harga


        binding.btnBack.setOnClickListener {
            val intent = Intent(this@ActivityDetail, MainActivity::class.java)
            startActivity(intent)

        }

        binding.btnBack.setOnClickListener {
            val intent = Intent(this@ActivityDetail, MainActivity::class.java)
            startActivity(intent)

        }

        binding.btnUpdate.setOnClickListener {
            Intent(this@ActivityDetail, ActivityUpdate::class.java).also {
                it.putExtra("id", id)
                it.putExtra("nama", nama)
                it.putExtra("nomor", nomor)
                it.putExtra("warna", warna)
                it.putExtra("harga", harga)
                it.putExtra("image", image)
                startActivity(it)

            }

        }

    }

}