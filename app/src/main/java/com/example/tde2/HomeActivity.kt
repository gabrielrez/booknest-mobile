package com.example.tde2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tde2.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerBooks: RecyclerView
    private lateinit var editTextSearch: EditText
    private lateinit var buttonSearch: Button
    private lateinit var adapter: BookAdapter
    private lateinit var profileBtn: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        recyclerBooks = findViewById(R.id.recyclerBooksMain)
        editTextSearch = findViewById(R.id.inputSearch)
        buttonSearch = findViewById(R.id.btnSearch)
        profileBtn = findViewById(R.id.userInfo)

        profileBtn.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        recyclerBooks.layoutManager = GridLayoutManager(this, 3)
        adapter = BookAdapter(emptyList()) { book ->
            val intent = Intent(this, BookActivity::class.java)
            intent.putExtra("book_external_id", book.externalId)
            intent.putExtra("book_title", book.title)
            intent.putExtra("book_author", book.author)
            intent.putExtra("book_description", book.description)
            intent.putExtra("book_cover", book.cover)
            startActivity(intent)
        }
        recyclerBooks.adapter = adapter

        buttonSearch.setOnClickListener {
            val query = editTextSearch.text.toString().trim()
            if (query.isNotEmpty()) {
                searchBooks(query)
            } else {
                Toast.makeText(this, "Digite o nome do livro", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun searchBooks(bookName: String) {
        RetrofitClient.instance.searchBooks(bookName).enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful && response.body() != null) {
                    val books = response.body()!!
                    adapter.updateBooks(books)
                } else {
                    Toast.makeText(this@HomeActivity, "Nenhum livro encontrado", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Toast.makeText(this@HomeActivity, "Erro na requisição: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
