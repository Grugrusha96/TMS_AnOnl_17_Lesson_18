package com.example.lesson18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.editTextLogin1)
        val userPass: EditText = findViewById(R.id.editTextPass2)
        val button: Button = findViewById(R.id.buttonLogin)
        val linkToReg: TextView = findViewById(R.id.textView3Login)
        linkToReg.setOnClickListener {
            val intent = Intent(this, Loagin::class.java)
            startActivity(intent)

        }
        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()



            if (login == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)
                if (isAuth) {
                    Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_LONG)
                        .show()
                    userLogin.text.clear()
                    userPass.text.clear()
                } else
                    Toast.makeText(this, "Пользователь $login не найден", Toast.LENGTH_LONG).show()


            }
        }
    }
}

