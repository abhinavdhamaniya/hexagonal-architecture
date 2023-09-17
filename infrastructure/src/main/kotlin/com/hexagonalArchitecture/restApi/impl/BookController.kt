package com.hexagonalArchitecture.restApi.impl

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.book.service.BookService
import com.hexagonalArchitecture.restApi.BookApi
import com.hexagonalArchitecture.restApi.request.BookRequest
import com.hexagonalArchitecture.restApi.response.BooksResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class BookController (private val service: BookService) : BookApi {
    override fun getBookById(id: UUID): ResponseEntity<Book> {
        return ResponseEntity.ok(service.getBookById(id))
    }

    override fun getAllBooks(): ResponseEntity<BooksResponse> {
        return ResponseEntity.ok(BooksResponse(service.getAllBooks()))
    }

    override fun createBook(request: BookRequest): ResponseEntity<Book> {
        return ResponseEntity.ok(service.createBook(request.toCommand()))
    }
}