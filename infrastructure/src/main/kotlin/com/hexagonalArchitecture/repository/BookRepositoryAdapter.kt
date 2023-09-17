package com.hexagonalArchitecture.repository

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.book.BookRepository
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryAdapter: BookRepository {

    override fun findById(id: String): Book {
        return Book("test", "test.author", "test.genre")
    }
}