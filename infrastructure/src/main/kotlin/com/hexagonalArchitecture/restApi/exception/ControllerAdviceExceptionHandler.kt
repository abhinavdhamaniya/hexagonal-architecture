package com.hexagonalArchitecture.restApi.exception

import com.hexagonalArchitecture.book.exception.BookNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ControllerAdviceExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(BookNotFoundException::class)
    internal fun exceptionHandler(exception: BookNotFoundException): ResponseEntity<ResponseError> {
        return handleInternalException(
            ResponseError(exception.message, NOT_FOUND.value()),
            HttpHeaders.EMPTY,
            NOT_FOUND
        )
    }

    @ExceptionHandler(Exception::class)
    internal fun exceptionHandler(exception: Exception): ResponseEntity<ResponseError> {
        return handleInternalException(
            ResponseError(exception.message, INTERNAL_SERVER_ERROR.value()),
            HttpHeaders.EMPTY,
            INTERNAL_SERVER_ERROR
        )
    }

    private fun handleInternalException(
        body: ResponseError?, headers: HttpHeaders, status: HttpStatus
    ) = ResponseEntity(body, headers, status)

}