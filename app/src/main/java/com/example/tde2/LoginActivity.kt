package com.example.tde2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity  : AppCompatActivity() {
    private lateinit var image: ImageView
    private lateinit var btnLogin: Button
    private lateinit var linkRegister: Button

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login)

        image = findViewById(R.id.mainImage)
        linkRegister = findViewById(R.id.linkRegister)
        btnLogin = findViewById(R.id.btnLogin)

        inputEmail = findViewById(R.id.etEmail)
        inputPassword = findViewById(R.id.etPassword)

        linkRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        image.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val email = inputEmail.text.toString().trim()
            val password = inputPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }
    }
}