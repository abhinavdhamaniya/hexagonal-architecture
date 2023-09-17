package com.hexagonalArchitecture.book.command

import com.hexagonalArchitecture.book.Book
import java.util.*

data class CreateBookCommand(val name: String, val author: String, val genre: String) {
    fun toBook() = Book(
        UUID.randomUUID(),
        name,
        author,
        genre
    )
}