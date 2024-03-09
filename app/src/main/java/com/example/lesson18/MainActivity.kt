package com.example.lesson18

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.util.Patterns
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateButtonState()
        mailTextWatcher()
        passTextWatcher()

        val userLogin: EditText = findViewById(R.id.editTextLogin1)
        val userPass: EditText = findViewById(R.id.editTextPass2)
        val button: Button = findViewById(R.id.buttonLogin)
        val linkToReg: TextView = findViewById(R.id.textView3Login)

        linkToReg.setOnClickListener {
            val intent = Intent(this, LoaginMain::class.java)
            startActivity(intent)

        }
        button.setOnClickListener {

            val intent = Intent(this, PageActivity::class.java)


            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()



            if (login == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                intent.putExtra("login", binding.editTextLogin.text.toString())
                intent.putExtra("pass", binding.editTextPass.text.toString())
                val isAuth = binding.getUser(login, pass)
                if (isAuth) {
                    Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_LONG)
                        .show()
                } else
                    Toast.makeText(this, "Пользователь $login не найден", Toast.LENGTH_LONG).show()

                startActivity(intent)
            }
        }
    }
//
    private fun mailTextWatcher() {
        binding.emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mailHelperText()

            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun validMail(): Boolean {
        val enteredEmail = binding.emailEditText.text.toString().trim()
        return Patterns.EMAIL_ADDRESS.matcher(enteredEmail).matches()
    }

    private fun mailHelperText() {
        if (validMail()) {

            val colorBlack = ContextCompat.getColor(this, R.color.black)
            binding.mailContainer.setHelperTextColor(ColorStateList.valueOf(colorBlack))
        } else {

            val colorWhite = ContextCompat.getColor(this, R.color.white)
            binding.mailContainer.setHelperTextColor(ColorStateList.valueOf(colorWhite))
        }
        updateButtonState()
    }


    //
    private fun passTextWatcher() {
        binding.passEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                passHelperText()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun validPass(): Boolean {
        return binding.passEditText.text.toString().trim().length > 5

    }

    private fun passHelperText() {
        if (validPass()) {

            val colorBlack = ContextCompat.getColor(this, R.color.black)
            binding.passwordContainer.setHelperTextColor(ColorStateList.valueOf(colorBlack))
        } else {
            val colorWhite = ContextCompat.getColor(this, R.color.white)
            binding.passwordContainer.setHelperTextColor(ColorStateList.valueOf(colorWhite))
        }
        updateButtonState()
    }
    private fun updateButtonState() {
        binding.nextButton.isEnabled = validMail() && validPass()
    }
}

