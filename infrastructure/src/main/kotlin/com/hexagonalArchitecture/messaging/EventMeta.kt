package com.hexagonalArchitecture.messaging

import java.time.LocalDateTime

data class EventMeta (
    val eventDate: LocalDateTime,
    val entityId: String,
    val publisherService: String
)