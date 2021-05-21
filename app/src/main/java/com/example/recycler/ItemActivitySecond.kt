package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycler.databinding.ActivityItemSecondBinding
import com.example.recycler.databinding.ActivityMainBinding

class ItemActivitySecond : AppCompatActivity() {
    private lateinit var binding:ActivityItemSecondBinding
    private lateinit var title: String
    private var iconID = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Recycler)
        binding = ActivityItemSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        title = intent.extras?.getString("title").toString()
        iconID = intent.extras?.getInt("iconID") ?: R.drawable.ic_logo

        binding.chosenItem.text = title
        binding.imgChosenIcon.setImageResource(iconID)
    }
}