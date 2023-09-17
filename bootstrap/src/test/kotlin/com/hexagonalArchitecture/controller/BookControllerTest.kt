package com.hexagonalArchitecture.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.hexagonalArchitecture.AutoConfigureTest
import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.book.repository.BookRepository
import com.hexagonalArchitecture.restApi.response.BooksResponse
import com.hexagonalArchitecture.testData.BookTestData.book
import com.hexagonalArchitecture.testData.BookTestData.bookRequest
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@AutoConfigureTest
@Sql(statements = ["DELETE FROM BOOK"])
class BookControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mapper: ObjectMapper

    @Autowired
    private lateinit var repository: BookRepository

    private val baseUrl= "/api/v1/books"

    @Test
    fun `should return book by id`() {
        // Given
        val id = UUID.randomUUID()
        val book = book(id)
        repository.create(book)

        // When
        val responseAsString = mockMvc.perform(
            MockMvcRequestBuilders.get("$baseUrl/$id").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn().response.contentAsString
        val response = mapper.readValue(responseAsString, Book::class.java)

        // Then
        SoftAssertions.assertSoftly {
            it.assertThat(response.id).isEqualTo(book.id)
            it.assertThat(response.name).isEqualTo(book.name)
            it.assertThat(response.author).isEqualTo(book.author)
            it.assertThat(response.genre).isEqualTo(book.genre)
        }
    }

    @Test
    fun `should return all books`() {
        // Given
        val book1 = book(UUID.randomUUID(), "test.name.1", "test.author.1", "test.genre.1")
        val book2 = book(UUID.randomUUID(), "test.name.2", "test.author.2", "test.genre.2")
        repository.create(book1)
        repository.create(book2)

        // When
        val responseAsString = mockMvc.perform(
            MockMvcRequestBuilders.get(baseUrl).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn().response.contentAsString
        val response = mapper.readValue(responseAsString, BooksResponse::class.java).books

        // Then
        SoftAssertions.assertSoftly {
            it.assertThat(response).hasSize(2)
            it.assertThat(response[0]).isEqualTo(book1)
            it.assertThat(response[1]).isEqualTo(book2)
        }
    }

    @Test
    fun `should create a book`() {
        // Given
        val request = bookRequest()

        // When
        val responseAsString = mockMvc.perform(
            MockMvcRequestBuilders.post(baseUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn().response.contentAsString
        val response = mapper.readValue(responseAsString, Book::class.java)

        // Then
        val savedBook = repository.findById(response.id)
        SoftAssertions.assertSoftly {
            it.assertThat(request.name).isEqualTo(savedBook.name)
            it.assertThat(request.author).isEqualTo(savedBook.author)
            it.assertThat(request.genre).isEqualTo(savedBook.genre)
        }
    }
}