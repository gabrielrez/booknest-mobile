package com.example.tde2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity  : AppCompatActivity() {
    private lateinit var image: ImageView
    private lateinit var btnRegister: Button
    private lateinit var linkLogin: Button

    private lateinit var inputName: EditText
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register)

        image = findViewById(R.id.mainImage)
        linkLogin = findViewById(R.id.linkLogin)
        btnRegister = findViewById(R.id.btnRegister)

        inputName = findViewById(R.id.etName)
        inputEmail = findViewById(R.id.etEmail)
        inputPassword = findViewById(R.id.etPassword)

        linkLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        image.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        btnRegister.setOnClickListener {
            val name = inputName.text.toString().trim()
            val email = inputEmail.text.toString().trim()
            val password = inputPassword.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }
    }
}