package com.aditya.storeshoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.aditya.storeshoes.databinding.ActivityUpdateBinding
import com.bumptech.glide.Glide

class ActivityUpdate : AppCompatActivity() {
    companion object {
        const val SUCCESUPDATE = "update_sukses"
    }

    private lateinit var binding: ActivityUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val id = intent.getStringExtra("id").toString()
        val nama = intent.getStringExtra("nama").toString()
        val nomor = intent.getStringExtra("nomor").toString()
        val warna = intent.getStringExtra("warna").toString()
        val harga = intent.getStringExtra("harga").toString()
        val image = intent.getStringExtra("image").toString()


        binding.edtuId.setText(id)
        binding.edtuNama.setText(nama)
        binding.edtuNomor.setText(nomor)
        binding.edtuWarna.setText(warna)
        binding.edtuHarga.setText(harga)
        binding.edtuImg.setText(image)





        val viewModel = ViewModelProvider(
            this@ActivityUpdate, ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]

        binding.btnSave.setOnClickListener {
            val id = binding.edtuId.text.toString()
            val nama = binding.edtuNama.text.toString()
            val warna = binding.edtuWarna.text.toString()
            val harga = binding.edtuHarga.text.toString()
            val nomor = binding.edtuNomor.text.toString()
            val image = binding.edtuImg.text.toString()

            val updateSepatu = UpdateSepatu(
                id.toInt(), nama, nomor.toInt(), warna, harga.toInt(), image
            )

            viewModel.updateSepatu(
                updateSepatu
            )


            viewModel.updateSepatu.observe(this) {
                Log.d("Response", it.toString())
                if (it.status) {
                    Intent().apply {
                        putExtra(SUCCESUPDATE, SUCCESUPDATE)
                        finish()
                    }
                }
                Toast.makeText(this@ActivityUpdate, it.message, Toast.LENGTH_SHORT).show()

            }
        }

    }
}
