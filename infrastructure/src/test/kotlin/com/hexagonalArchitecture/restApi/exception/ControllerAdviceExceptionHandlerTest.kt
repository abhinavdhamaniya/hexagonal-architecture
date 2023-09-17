package com.hexagonalArchitecture.restApi.exception

import com.hexagonalArchitecture.book.exception.BookNotFoundException
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import java.util.UUID

class ControllerAdviceExceptionHandlerTest {

    private lateinit var handler: ControllerAdviceExceptionHandler

    @BeforeEach
    fun setup() {
        handler = ControllerAdviceExceptionHandler()
    }

    @Test
    fun `should return status as not found when BookNotFoundException is thrown`() {
        // Given
        val id = UUID.randomUUID()
        val exception = BookNotFoundException(id)

        // When
        val result = handler.exceptionHandler(exception)

        // Then
        SoftAssertions.assertSoftly {
            it.assertThat(result.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
            it.assertThat(result.headers).isEqualTo(HttpHeaders.EMPTY)
            it.assertThat((result.body as ResponseError).message).isEqualTo("Book with id: $id not found")
        }

    }
}