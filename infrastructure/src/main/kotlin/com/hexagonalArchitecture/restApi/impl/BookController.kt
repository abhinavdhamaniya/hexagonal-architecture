package com.hexagonalArchitecture.restApi.impl

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.book.BookService
import com.hexagonalArchitecture.restApi.BookApi
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController (private val service: BookService) : BookApi {
    override fun getBookById(id: String): ResponseEntity<Book> {
        return ResponseEntity.ok(service.getBookById(id))
    }
}