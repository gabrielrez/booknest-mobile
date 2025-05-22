package com.example.tde2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LibraryAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<LibraryAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageBook: ImageView = itemView.findViewById(R.id.imageBook)
        val nameBook: TextView = itemView.findViewById(R.id.nameBook)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.nameBook.text = book.name
        holder.imageBook.setImageResource(book.imageResId)
    }

    override fun getItemCount(): Int = books.size
}