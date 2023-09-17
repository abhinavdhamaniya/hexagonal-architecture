package com.hexagonalArchitecture.restApi.impl

import com.hexagonalArchitecture.Book
import com.hexagonalArchitecture.restApi.BookApi
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController : BookApi {
    override fun getBookById(id: String): ResponseEntity<Book> {
        return ResponseEntity.ok(Book("", "", ""))
    }
}