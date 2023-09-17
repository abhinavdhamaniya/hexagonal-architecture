package com.hexagonalArchitecture.restApi

import com.hexagonalArchitecture.book.Book
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping(path = ["/api/v1/books"])
interface BookApi {

    @GetMapping("/{id}")
    @Operation(
            method = "GET",
            summary = "Get book by id",
            description = "Get book by id",
            operationId = "GetBookById"
    )
    fun getBookById(@PathVariable id: String): ResponseEntity<Book>
}