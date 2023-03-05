package com.aditya.storeshoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditya.storeshoes.databinding.ActivityPutBinding
import com.aditya.storeshoes.databinding.ActivityUpdateBinding

class ActivityUpdate : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var database: AppDatabase

    class AppDatabase {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id")
        val nama = intent.getStringExtra("nama")
        val nomor = intent.getStringExtra("nomor")
        val warna = intent.getStringExtra("warna")
        val harga = intent.getStringExtra("harga")
        val image = intent.getStringExtra("image")


        binding.edtNama.setText(nama)
        binding.edtHarga.setText(harga)
        binding.edtNomor.setText(nomor)
        binding.edtHarga.setText(harga)
        binding.edtImg.setText(image)

        binding.btnEdit.setOnClickListener {

        }
    }
}