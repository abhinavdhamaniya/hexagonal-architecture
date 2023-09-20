package com.hexagonalArchitecture.messaging.producer.book

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.book.producer.BookProducer
import com.hexagonalArchitecture.messaging.EventMeta
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener
import java.time.LocalDateTime

@Component
class BookProducerAdapter(
    private val streamBridge: StreamBridge
) : BookProducer {

    private val log = LoggerFactory.getLogger(BookProducerAdapter::class.java)

    companion object {
        const val OUTPUT_CHANNEL = "bookProducer-out-0"
    }

    @EventListener(Book::class)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    override fun publish(book: Book) {
        streamBridge.send(
            OUTPUT_CHANNEL,
            BookEvent(
                EventMeta(
                    LocalDateTime.now(),
                    book.id.toString(),
                    "hexagonal-architecture"
                ),
                book
            )
        )
        log.info("Book message is sent from producer!")
    }
}