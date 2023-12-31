package com.hexagonalArchitecture.book.service

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.book.command.CreateBookCommand
import com.hexagonalArchitecture.book.processor.BookProcessor
import com.hexagonalArchitecture.book.producer.BookProducer
import com.hexagonalArchitecture.book.repository.BookRepository
import java.util.*

class BookService(
    private val repository: BookRepository,
    private val processor: BookProcessor,
    private val producer: BookProducer
) {

    fun getBookById(id: UUID): Book {
        return repository.findById(id).also { processor.onRead(it) }
    }

    fun getAllBooks(): List<Book> {
        return repository.findAll().onEach { processor.onRead(it) }
    }

    fun createBook(command: CreateBookCommand): Book {
        return repository.create(command.toBook()).also { processor.onRead(it) }
    }

    fun createBookByPublisher(command: CreateBookCommand): Book {
        val book = command.toBook()
        producer.publish(book).also { return book }
    }
}