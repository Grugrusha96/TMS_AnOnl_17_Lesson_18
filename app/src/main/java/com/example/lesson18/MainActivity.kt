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
import com.example.lesson18.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateButtonState()
        loginTextWatcher()
        passTextWatcher()

        binding.editButtonLogin.setOnClickListener {

            val intent = Intent(this, PageActivity::class.java)

                intent.putExtra("mail", binding.editTextMail1.text.toString())
                intent.putExtra("pass", binding.editTextPass1.text.toString())
              startActivity(intent)
            }
        }
        //
        private fun loginTextWatcher() {
            binding.editTextMail1.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    loginHelperText()

                }

                override fun afterTextChanged(p0: Editable?) {}
            })
        }

        private fun validMail(): Boolean {
            val enteredLogin = binding.editTextMail1.text.toString().trim()
            return Patterns.EMAIL_ADDRESS.matcher(enteredLogin).matches()
        }

        private fun loginHelperText() {
            if (validMail()) {
                binding.editTextMail11.helperText = getString(R.string.nameMail)
                val colorGreen = ContextCompat.getColor(this,R.color.black)
                binding.editTextMail11.setHelperTextColor(ColorStateList.valueOf(colorGreen))
            } else {
                binding.editTextMail11.helperText = getString(R.string.nameMail1)
                val colorRed = ContextCompat.getColor(this, R.color.white)
                binding.editTextMail11.setHelperTextColor(ColorStateList.valueOf(colorRed))
            }
            updateButtonState()
        }


        //
        private fun passTextWatcher() {
            binding.editTextPass1.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    passHelperText()
                }

                override fun afterTextChanged(p0: Editable?) {}
            })
        }

        private fun validPass(): Boolean {
            return binding.editTextPass1.text.toString().trim().length > 5

        }

        private fun passHelperText() {
            if (validPass()) {
                binding.editTextPass11.helperText = getString(R.string.namePass)
                val colorGreen = ContextCompat.getColor(this, R.color.black)
                binding.editTextPass11.setHelperTextColor(ColorStateList.valueOf(colorGreen))
            } else {
                binding.editTextPass11.helperText = getString(R.string.namePass1)
                val colorRed = ContextCompat.getColor(this, R.color.white)
                binding.editTextPass11.setHelperTextColor(ColorStateList.valueOf(colorRed))
            }
            updateButtonState()
        }

        private fun updateButtonState() {
            binding.editButtonLogin.isEnabled = validMail() && validPass()
        }
    }


