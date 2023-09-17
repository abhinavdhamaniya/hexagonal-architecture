package com.hexagonalArchitecture.book.repository

import com.hexagonalArchitecture.book.Book
import java.util.UUID

interface BookRepository {

    fun create(book: Book): Book
    fun findById(id: UUID): Book
    fun findAll(): List<Book>
}