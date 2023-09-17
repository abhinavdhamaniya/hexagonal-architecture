package com.hexagonalArchitecture.book.processor

import com.hexagonalArchitecture.address.provider.AddressProvider
import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.company.provider.CompanyProvider

class BookProcessor(
    private val companyProvider: CompanyProvider,
    private val addressProvider: AddressProvider
) {

    fun onRead(book: Book) {
        book.publishingCompany = companyProvider.getCompany()
        book.storeAddress = addressProvider.getAddress()
    }
}