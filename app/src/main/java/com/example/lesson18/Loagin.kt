package com.example.lesson18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Loagin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loagin)

        val userLogin: EditText = findViewById(R.id.editTextLogin)
        val userMail: EditText = findViewById(R.id.editTextMail)
        val userPass: EditText = findViewById(R.id.editTextPass)
        val userPass1: EditText = findViewById(R.id.editTextPass1)
        val button: Button = findViewById(R.id.buttonReg)

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val mail = userMail.text.toString().trim()
            val pass = userPass.text.toString().trim()
            val pass1 = userPass1.text.toString().trim()


            if (pass == pass1)
                Toast.makeText(this, "Поля не совпадают", Toast.LENGTH_LONG).show()
            else {
                (pass != pass1)

                if (login == "" || mail == "" || pass == "" || pass1 == "")
                    Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
                else {
                    val user = User(login, mail, pass, pass1)


                    val db = DbHelper(this, null)
                    db.addUser(user)
                    Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                    userLogin.text.clear()
                    userMail.text.clear()
                    userPass.text.clear()
                    userPass1.text.clear()

                }
            }
        }
    }
}