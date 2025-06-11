package com.example.tde2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tde2.api.RetrofitClient
import retrofit2.Response
import retrofit2.Call

class ProfileActivity : AppCompatActivity() {
    private lateinit var img: ImageView
    private lateinit var recyclerLibrary: RecyclerView
    private lateinit var adapter: LibraryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile)

        img = findViewById(R.id.mainImage)
        recyclerLibrary = findViewById(R.id.recyclerLibrary)

        img.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        recyclerLibrary.layoutManager = GridLayoutManager(this, 3)
        adapter = LibraryAdapter(emptyList()) {
            startActivity(Intent(this, BookActivity::class.java))
        }
        recyclerLibrary.adapter = adapter

        fetchUserBooks()
    }

    private fun fetchUserBooks() {
        RetrofitClient.instance.getUserBooks().enqueue(object : retrofit2.Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful && response.body() != null) {
                    val books = response.body()!!
                    adapter.updateBooks(books)
                } else {
                    Toast.makeText(this@ProfileActivity, "Nenhum livro encontrado", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Toast.makeText(this@ProfileActivity, "Erro ao carregar livros: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}