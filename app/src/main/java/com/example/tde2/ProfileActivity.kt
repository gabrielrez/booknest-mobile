package com.example.tde2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileActivity : AppCompatActivity() {
    private lateinit var img: ImageView
    private lateinit var recyclerLibrary: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile)

        img = findViewById(R.id.mainImage)
        recyclerLibrary = findViewById(R.id.recyclerLibrary)

        img.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        val listLibrary = listOf(
            Book("Harry Potter", R.drawable.capa_harry_potter),
            Book("Os irmãos Karamazov", R.drawable.capa_irmaos),
            Book("Cristianismo puro e simples", R.drawable.capa_cristianismo)
        )

        recyclerLibrary.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerLibrary.layoutManager = GridLayoutManager(this, 3)
        recyclerLibrary.adapter = LibraryAdapter(listLibrary) {
            startActivity(Intent(this, BookActivity::class.java))
        }
    }
}