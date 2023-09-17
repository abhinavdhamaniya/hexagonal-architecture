package com.hexagonalArchitecture.book

import java.util.UUID

data class Book (
    val id: UUID,
    val name: String,
    val author: String,
    val genre: String
)
