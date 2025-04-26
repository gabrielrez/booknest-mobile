package com.example.tde2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(){
    private lateinit var profilePicture: ImageView
    private lateinit var logo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)

        profilePicture = findViewById(R.id.avatar)
        logo = findViewById(R.id.logoInicio)

        logo.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        profilePicture.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }
}