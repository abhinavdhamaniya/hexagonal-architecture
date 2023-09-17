package com.hexagonalArchitecture.config

import com.hexagonalArchitecture.address.provider.AddressProvider
import com.hexagonalArchitecture.book.processor.BookProcessor
import com.hexagonalArchitecture.book.repository.BookRepository
import com.hexagonalArchitecture.book.service.BookService
import com.hexagonalArchitecture.company.provider.CompanyProvider
import com.hexagonalArchitecture.feign.address.adapter.AddressAdapter
import com.hexagonalArchitecture.feign.company.adapter.CompanyAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DomainConfig {

    @Bean
    fun companyProvider() = CompanyAdapter()

    @Bean
    fun addressProvider() = AddressAdapter()

    @Bean
    fun processor(
        companyProvider: CompanyProvider,
        addressProvider: AddressProvider
    ) = BookProcessor(companyProvider, addressProvider)

    @Bean
    fun bookService(
        repository: BookRepository,
        processor: BookProcessor
    ) = BookService(repository, processor)
}