package com.hexagonalArchitecture.book.service

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.book.command.CreateBookCommand
import com.hexagonalArchitecture.book.repository.BookRepository
import java.util.UUID

class BookService(private val repository: BookRepository) {

    fun getBookById(id: UUID): Book {
        return repository.findById(id)
    }

    fun getAllBooks(): List<Book> {
        return repository.findAll()
    }

    fun createBook(command: CreateBookCommand): Book {
        return repository.create(command.toBook())
    }
}