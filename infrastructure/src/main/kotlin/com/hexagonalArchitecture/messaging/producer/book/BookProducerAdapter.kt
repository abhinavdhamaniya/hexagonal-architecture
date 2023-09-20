package com.hexagonalArchitecture.messaging.producer.book

import com.hexagonalArchitecture.book.Book
import com.hexagonalArchitecture.book.producer.BookProducer
import com.hexagonalArchitecture.messaging.EventMeta
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

    @EventListener(Book::class)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    override fun publish(book: Book) {
        streamBridge.send(
            "test-destination-my-exchange",
            BookEvent(
                EventMeta(
                    LocalDateTime.now(),
                    book.id.toString(),
                    "hexagonal-architecture"
                ),
                book
            )
        )
    }
}