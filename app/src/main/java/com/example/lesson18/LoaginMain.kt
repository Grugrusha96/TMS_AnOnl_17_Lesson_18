package com.example.lesson18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast



class LoaginMain : AppCompatActivity() {

    private lateinit var binding: MainLoaginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainLoaginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userLogin: EditText = findViewById(R.id.editTextLogin)
        val userMail: EditText = findViewById(R.id.editTextMail)
        val userPass: EditText = findViewById(R.id.editTextPass)
        val userPass1: EditText = findViewById(R.id.editTextPass1)
        val button: Button = findViewById(R.id.buttonReg)
        val reg: TextView = findViewById(R.id.textView3Loagin)

        reg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
            button.setOnClickListener {

                val intent = Intent (this, PageActivity::class.java)
                startActivity(intent)


            val login = userLogin.text.toString().trim()
            val mail = userMail.text.toString().trim()
            val pass = userPass.text.toString().trim()
            val pass1 = userPass1.text.toString().trim()


            if (pass != pass1)
                Toast.makeText(this, "Пaроли не совпадают", Toast.LENGTH_LONG).show()
            else {
                (pass == pass1)

                if (login == "" || mail == "" || pass == "" || pass1 == "")
                    Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
                else {
                    val intent = Intent(this, PageActivity::class.java)
                    intent.putExtra("mail", binding.editTextMail.text.toString())
                    intent.putExtra("login", binding.editTextLogin.text.toString())
                    intent.putExtra("pass", binding.editTextPass.text.toString())
                    intent.putExtra("pass1", binding.editTextPass1.text.toString())

                    Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                }
            }
        }
    }
}