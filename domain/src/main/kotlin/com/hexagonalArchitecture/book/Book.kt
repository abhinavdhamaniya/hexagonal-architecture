package com.hexagonalArchitecture.book

import com.hexagonalArchitecture.address.Address
import com.hexagonalArchitecture.company.Company
import java.util.UUID

data class Book (
    val id: UUID,
    val name: String,
    val author: String,
    val genre: String,
    var publishingCompany: Company ?= null,
    var storeAddress: Address ?= null
)
