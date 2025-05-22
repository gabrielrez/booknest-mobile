package com.example.tde2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class BookActivity : AppCompatActivity() {
    private lateinit var mainImage: ImageView
    private lateinit var addBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.book)

        mainImage = findViewById(R.id.mainImage)
        addBtn = findViewById(R.id.add)

        mainImage.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }

        addBtn.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}