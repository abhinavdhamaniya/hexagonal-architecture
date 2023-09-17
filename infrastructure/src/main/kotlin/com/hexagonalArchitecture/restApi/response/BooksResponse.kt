package com.hexagonalArchitecture.restApi.response

import com.hexagonalArchitecture.book.Book

data class BooksResponse (
    var books: List<Book>
) {
    constructor() : this(listOf())
}