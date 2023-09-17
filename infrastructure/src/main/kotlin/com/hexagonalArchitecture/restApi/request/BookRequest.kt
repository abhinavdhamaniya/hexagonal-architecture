package com.hexagonalArchitecture.restApi.request

import com.hexagonalArchitecture.book.command.CreateBookCommand

data class BookRequest (val name: String, val author: String, val genre: String) {
    fun toCommand() = CreateBookCommand(name, author, genre)
}