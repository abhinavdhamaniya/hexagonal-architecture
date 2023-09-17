package com.hexagonalArchitecture.book

interface BookRepository {

    fun findById(id: String): Book
}