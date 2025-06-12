package com.example.tde2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.tde2.api.BookRequest
import com.example.tde2.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookActivity : AppCompatActivity() {
    private lateinit var mainImage: ImageView
    private lateinit var titleText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var coverImage: ImageView
    private lateinit var addBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.book)

        titleText = findViewById(R.id.username)
        descriptionText = findViewById(R.id.description)
        coverImage = findViewById(R.id.cover)
        addBtn = findViewById(R.id.add)
        mainImage = findViewById(R.id.mainImage)

        val externalId = intent.getStringExtra("book_external_id")
        val bookTitle = intent.getStringExtra("book_title") ?: "Título não disponível"
        val bookAuthor = intent.getStringExtra("book_author") ?: ""
        val bookDescription = intent.getStringExtra("book_description") ?: "Descrição não disponível"
        val bookCoverUrl = intent.getStringExtra("book_cover")

        titleText.text = bookTitle
        descriptionText.text = bookDescription
        Glide.with(this)
            .load(bookCoverUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(coverImage)

        mainImage = findViewById(R.id.mainImage)
        addBtn = findViewById(R.id.add)

        mainImage.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }

        addBtn.setOnClickListener {
            val bookToAdd = BookRequest(
                external_id = externalId ?: "id_default",
                title = titleText.text.toString(),
                description = descriptionText.text.toString(),
                author = "",
                cover = intent.getStringExtra("book_cover")
            )

            RetrofitClient.instance.addBook(bookToAdd).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@BookActivity, "Livro adicionado com sucesso!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@BookActivity, HomeActivity::class.java))
                    } else {
                        val errorBody = response.errorBody()?.string()
                        Toast.makeText(this@BookActivity, "Erro ${response.code()}: $errorBody", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@BookActivity, "Falha na requisição: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}