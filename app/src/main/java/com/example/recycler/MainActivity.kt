package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val items = mutableListOf<Model>()
    private lateinit var adapter : RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Recycler)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        setData()
    }

    private fun init() {
        adapter = RecyclerAdapter(items)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
    }

    private fun setData() {
        items.add(Model(R.drawable.ic_temaki, "temaki".toUpperCase(), resources.getString(R.string.temaki_descript)))
        items.add(Model(R.drawable.ic_gunkan_maki, "gunkan maki".toUpperCase(), resources.getString(R.string.gunkan_maki_descript)))
        items.add(Model(R.drawable.ic_nigiri, "nigiri".toUpperCase(), resources.getString(R.string.nigiri_descript)))
        items.add(Model(R.drawable.ic_hosomaki, "hosomaki".toUpperCase(), resources.getString(R.string.hosomaki_descript)))
        items.add(Model(R.drawable.ic_roll, "roll".toUpperCase(), resources.getString(R.string.roll_descript)))
        items.add(Model(R.drawable.ic_grilled_and_fried, "grilled and fried".toUpperCase(), resources.getString(R.string.grilled_and_fried_descript)))
        items.add(Model(R.drawable.ic_sushi_sets, "sushi sets".toUpperCase(), resources.getString(R.string.sushi_sets_descript)))
        items.add(Model(R.drawable.ic_gyoza, "gyoza".toUpperCase(), resources.getString(R.string.gyoza_descript)))
        items.add(Model(R.drawable.ic_desserts, "desserts".toUpperCase(), resources.getString(R.string.desserts_descript)))
        items.add(Model(R.drawable.ic_salads, "salads".toUpperCase(), resources.getString(R.string.salads_descript)))
        adapter.notifyDataSetChanged()
    }
}