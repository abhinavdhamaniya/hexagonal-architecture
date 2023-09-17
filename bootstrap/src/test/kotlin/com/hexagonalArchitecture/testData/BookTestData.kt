package com.hexagonalArchitecture.testData

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.restApi.request.BookRequest
import java.util.*

object BookTestData {

    fun book(id: UUID) = Book(id, "test.name", "test.author", "test.genre")

    fun book(id: UUID, name: String, author: String, genre: String) = Book(id, name, author, genre)

    fun bookRequest() = BookRequest("test.name.1", "test.author.1", "test.genre.1")
}