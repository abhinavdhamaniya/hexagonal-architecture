package com.hexagonalArchitecture.book.exception

import java.util.UUID

class BookNotFoundException(id: UUID): RuntimeException("Book with id: $id not found")