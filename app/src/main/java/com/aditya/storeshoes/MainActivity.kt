package com.aditya.storeshoes

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditya.storeshoes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: Adapterstore
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lySwip.setOnRefreshListener {

            binding.lySwip.isRefreshing = false
            getData()
        }


        viewModel = ViewModelProvider(
            this@MainActivity, ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]

        mAdapter = Adapterstore(
            onClick = { store ->

                Intent(this@MainActivity, ActivityDetail::class.java).also {
                    it.putExtra("id", store.id)
                    it.putExtra("nama", store.nama)
                    it.putExtra("nomor", store.nomor)
                    it.putExtra("warna", store.warna)
                    it.putExtra("harga", store.harga)
                    it.putExtra("image", store.image)
                    startActivity(it)
                }
            },
            onLongClick = { shoes ->

                val builder = AlertDialog.Builder(this)
                builder.setMessage("HAPUS?")
                builder.setPositiveButton("OK") { dialog, which ->
                    viewModel.deleteSepatu(shoes.id.toString())
                    dialog.dismiss()
                    getData()
                }
                builder.setNegativeButton("JANGAN") { dialog, which ->
                    dialog.dismiss()
                }
                val dialog = builder.create()
                dialog.show()
            }
        )

        getData()

        viewModel.isLoading.observe(this@MainActivity)
        { isLoading ->
            binding.progressBar.isVisible = isLoading

        }
        binding.imgDelete.setOnClickListener()
        {
            val intent = Intent(this@MainActivity, ActivityPut::class.java)
            startActivity(intent)
        }

        binding.imgEdit.setOnClickListener() {
            val intent = Intent(this@MainActivity, ActivityUpdate::class.java)
            startActivity(intent)
        }

    }

    private fun getData() {
        viewModel.getStore()
        viewModel.store.observe(this@MainActivity) { listData ->
            Log.d("Response::::::", "onCreate: $listData")
            mAdapter.submitList(listData)
            binding.rvStore.adapter = mAdapter
            binding.rvStore.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvStore.setHasFixedSize(true)
        }
    }
}