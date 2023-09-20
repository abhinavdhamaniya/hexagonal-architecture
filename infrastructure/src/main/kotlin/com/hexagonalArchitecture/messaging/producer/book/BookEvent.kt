package com.hexagonalArchitecture.messaging.producer.book

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.messaging.EventMeta

data class BookEvent(
    val eventMeta: EventMeta,
    val payload: Book
)