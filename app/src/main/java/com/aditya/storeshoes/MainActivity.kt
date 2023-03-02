package com.aditya.storeshoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditya.storeshoes.ActivityPut.Companion.SUCCESINPUT
import com.aditya.storeshoes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: Adapterstore
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        binding.imgDelete.setOnClickListener {
//            val intent = Intent(this@MainActivity, ActivityPut::class.java)
//            startActivity(intent)
//        }

//        val adapter : Adapterstore
//
//        val list
//        database = appDatabase.getIntents(applocationContext)
//        adapter = Adapterstore(list)
//        adapter.setDialog.objek: AdaptorStore.Dialog{
//
//        }

        viewModel = ViewModelProvider(
            this@MainActivity, ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]

        mAdapter = Adapterstore { store ->
//            val intent = if (while == 1) {
            Intent(this@MainActivity, ActivityDetail::class.java).also {
                it.putExtra("id", store.id)
                it.putExtra("nama", store.nama)
                it.putExtra("nomor", store.nomor)
                it.putExtra("warna", store.warna)
                it.putExtra("harga", store.harga)
                it.putExtra("image", store.image)
                startActivity(it)
            }
//            } else (while == 0){
//                databaseList().delete(list[position])
//                getData()
//            }else{
//                dialog.dismiss()
//        }

        }

        viewModel.store.observe(this@MainActivity) { listData ->
            Log.d("Response::::::", "onCreate: $listData")
            mAdapter.submitList(listData)
            binding.rvStore.adapter = mAdapter
            binding.rvStore.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvStore.setHasFixedSize(true)
        }

        viewModel.isLoading.observe(this@MainActivity) { isLoading ->

            binding.progressBar.isVisible = isLoading
        }
        binding.imgDelete.setOnClickListener {
            val intent = Intent(this@MainActivity, ActivityPut::class.java)
            startActivity(intent)


        }
    }

}