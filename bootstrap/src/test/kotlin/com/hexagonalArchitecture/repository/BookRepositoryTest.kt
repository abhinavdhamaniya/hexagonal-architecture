package com.hexagonalArchitecture.repository

import com.hexagonalArchitecture.book.repository.BookRepository
import com.hexagonalArchitecture.repository.mapper.BookMapper
import com.hexagonalArchitecture.testData.BookTestData.book
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.context.annotation.Import
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import java.util.*

@JdbcTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
@Sql(statements = ["DELETE FROM BOOK"])
@Import(BookMapper::class)
class BookRepositoryTest {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    @Autowired
    private lateinit var mapper: BookMapper

    private lateinit var repository: BookRepository

    @BeforeEach
    fun setup() {
        repository = BookRepositoryAdapter(jdbcTemplate, mapper)
    }

    @Test
    fun `should create a book`() {
        // Given
        val book = book(UUID.randomUUID())

        // When
        val savedId = repository.create(book).id

        // Then
        val savedBook = repository.findById(savedId)
        Assertions.assertThat(savedBook).isEqualTo(book)
    }

    @Test
    fun `should return a book by id`() {
        // Given
        val book = book(UUID.randomUUID())
        repository.create(book)

        // When
        val result = repository.findById(book.id)

        // Then
        Assertions.assertThat(result).isEqualTo(book)
    }

    @Test
    fun `should return all books`() {
        // Given
        val book1 = book(UUID.randomUUID())
        val book2 = book(UUID.randomUUID())
        repository.create(book1)
        repository.create(book2)

        // When
        val result = repository.findAll()

        // Then
        Assertions.assertThat(result).hasSize(2)
        Assertions.assertThat(result[0]).isEqualTo(book1)
        Assertions.assertThat(result[1]).isEqualTo(book2)
    }
}