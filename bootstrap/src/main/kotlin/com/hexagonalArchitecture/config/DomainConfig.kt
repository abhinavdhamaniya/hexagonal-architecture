package com.hexagonalArchitecture.config

import com.hexagonalArchitecture.book.repository.BookRepository
import com.hexagonalArchitecture.book.service.BookService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DomainConfig {

    @Bean
    fun bookService(repository: BookRepository) = BookService(repository)
}