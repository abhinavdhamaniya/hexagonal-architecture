package com.hexagonalArchitecture.messaging.consumer.book

import com.hexagonalArchitecture.messaging.producer.book.BookEvent
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@Configuration
class BookConsumer: Consumer<BookEvent> {

    private val log = LoggerFactory.getLogger(BookConsumer::class.java)

    override fun accept(message: BookEvent) {
        log.info("Book message is received in book consumer!")
    }
}