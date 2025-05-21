package com.example.tde2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    private lateinit var profilePicture: ImageView
    private lateinit var logo: ImageView
    private lateinit var recyclerBooks: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)

        profilePicture = findViewById(R.id.avatar)
        logo = findViewById(R.id.logoInicio)
        recyclerBooks = findViewById(R.id.recyclerBooksMain)

        logo.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        profilePicture.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }

        val listBooks = listOf(
            Book("Harry Potter", R.drawable.capa_harry_potter),
            Book("Os irmãos Karamazov", R.drawable.capa_irmaos),
            Book("Dom Casmurro", R.drawable.capa_dom_casmurro)
        )

        recyclerBooks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerBooks.adapter = BookAdapter(listBooks)
    }
}