package com.hexagonalArchitecture.restApi.response

import com.hexagonalArchitecture.book.Book

data class BooksResponse (
    val books: List<Book>
)