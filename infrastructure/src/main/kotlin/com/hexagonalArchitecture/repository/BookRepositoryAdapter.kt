package com.hexagonalArchitecture.repository

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.book.exception.BookNotFoundException
import com.hexagonalArchitecture.book.repository.BookRepository
import com.hexagonalArchitecture.repository.mapper.BookMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class BookRepositoryAdapter(private val mapper: BookMapper) : BookRepository {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    private val insertQuery = "INSERT INTO BOOK VALUES(?, ?, ?, ?)"
    private val findByIdQuery = "SELECT * FROM BOOK WHERE ID = ?"
    private val findAllQuery = "SELECT * FROM BOOK"

    override fun create(book: Book): Book {
        jdbcTemplate.update(insertQuery, book.id, book.name, book.author, book.genre)
        return findById(book.id)
    }

    override fun findById(id: UUID): Book {
        try {
            return jdbcTemplate.queryForObject(findByIdQuery, mapper, id.toString())!!
        } catch (exc: EmptyResultDataAccessException) {
            throw BookNotFoundException(id)
        }
    }

    override fun findAll(): List<Book> {
        return jdbcTemplate.query(findAllQuery, mapper)
    }
}