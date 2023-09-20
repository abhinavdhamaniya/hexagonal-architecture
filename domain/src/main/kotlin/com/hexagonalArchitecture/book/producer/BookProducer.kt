package com.hexagonalArchitecture.book.producer

import com.hexagonalArchitecture.book.Book

interface BookProducer {

    fun publish(book: Book)
}