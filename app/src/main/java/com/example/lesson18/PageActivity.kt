package com.example.lesson18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson18.databinding.ActivityPageBinding

class PageActivity : AppCompatActivity() {


    private lateinit var binding: ActivityPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pass = intent.getStringExtra("pass")
        val mail = intent.getStringExtra("mail")

        binding.result.text =

        "Mail: $mail\nmail: $pass\npass"


        binding.backButton.setOnClickListener {
            finish()
        }
    }
}