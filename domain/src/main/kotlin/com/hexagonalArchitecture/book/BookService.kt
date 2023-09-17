package com.hexagonalArchitecture.book

class BookService(private val repository: BookRepository) {

    fun getBookById(id: String): Book {
        return repository.findById(id)
    }
}