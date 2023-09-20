package com.hexagonalArchitecture.restApi

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.restApi.request.BookRequest
import com.hexagonalArchitecture.restApi.response.BooksResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.util.UUID

@RequestMapping(path = ["/api/v1/books"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Tag(name = "Books API")
interface BookApi {

    @GetMapping("/{id}")
    @Operation(
            method = "GET",
            summary = "Get book by id",
            description = "Get book by id",
            operationId = "GetBookById"
    )
    fun getBookById(@PathVariable id: UUID): ResponseEntity<Book>

    @GetMapping
    @Operation(
        method = "GET",
        summary = "Get book by id",
        description = "Get book by id",
        operationId = "GetBookById"
    )
    fun getAllBooks(): ResponseEntity<BooksResponse>

    @PostMapping
    @Operation(
        method = "POST",
        summary = "Create book",
        description = "Create book",
        operationId = "CreateBook"
    )
    fun createBook(@RequestBody request: BookRequest): ResponseEntity<Book>

    @PostMapping("/by-producer")
    @Operation(
        method = "POST",
        summary = "Create book by publisher",
        description = "Create book by publisher",
        operationId = "CreateBookByPublisher"
    )
    fun createBookByProducer(@RequestBody request: BookRequest): ResponseEntity<Book>
}