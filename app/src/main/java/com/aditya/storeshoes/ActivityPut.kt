package com.aditya.storeshoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aditya.storeshoes.databinding.ActivityMainBinding
import com.aditya.storeshoes.databinding.ActivityPutBinding

class ActivityPut : AppCompatActivity() {
    companion object {
        const val SUCCESINPUT = "Input_Sukses"
    }

    private lateinit var binding: ActivityPutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(
            this@ActivityPut, ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]

        binding.btnPut.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val warna = binding.etWarna.text.toString()
            val harga = binding.etHarga.text.toString()
            val nomor = binding.etNomor.text.toString()
            val image = binding.etImg.text.toString()

            val inputSepatu = InputSepatu(
                nama, nomor.toInt(), warna, harga.toInt(), image
            )

            viewModel.inputSepatu(
                inputSepatu
            )

            viewModel.inputSepatu.observe(this@ActivityPut) {
                Log.d("Response", it.toString())
                if (it.status) {
                    Intent().apply {
                        putExtra(SUCCESINPUT, SUCCESINPUT)
                        finish()
                    }
                }
                Toast.makeText(this@ActivityPut, it.message, Toast.LENGTH_SHORT).show()

//                    binding.btnPut.setOnClickListener {
////                       it.setOnClickListener{nama}
////                        it.setOnClickListener{warna}
////                        it.setOnClickListener{harga}
////
//
//                        val nama = binding.etNama.text.toString()
//                        val warna = binding.etWarna.text.toString()
//                        val harga = binding.etHarga.text.toString()
//                        val nomor = binding.etNomor.text.toString()
//                        val image = binding.etImg.text.toString()
//                    }
            }


//        arrayListOf<InputSepatu>().clear()
//
//        val jsonArray = response?.optJSONArray("result")
//
//        if(jsonArray?.length() == 0){
//            loading.dismiss()
//            Toast.makeText(applicationContext,"Student data is empty, Add the data first",Toast.LENGTH_SHORT).show()
//        }

        }
    }
}