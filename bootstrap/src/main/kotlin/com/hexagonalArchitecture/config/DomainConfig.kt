package com.hexagonalArchitecture.config

import com.hexagonalArchitecture.book.BookRepository
import com.hexagonalArchitecture.book.BookService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DomainConfig {

    @Bean
    fun bookService(repository: BookRepository) = BookService(repository)
}