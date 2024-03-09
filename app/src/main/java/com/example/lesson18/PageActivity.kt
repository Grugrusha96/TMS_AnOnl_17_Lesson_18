package com.example.lesson18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PageActivity : AppCompatActivity() {


    private lateinit var binding: ActivityPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mail = intent.getStringExtra("mail")
        val pass = intent.getStringExtra("pass")
        val pass1 = intent.getStringExtra("pass1")
        val login = intent.getStringExtra("login")

        binding.result.text =

        "Email: $mail\nPassword: $pass\nCheckBox1: $pass1\nCheckBox2: $login\nRadioButton"


        binding.backButton.setOnClickListener {
            finish()
        }
    }
}