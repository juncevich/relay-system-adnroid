package com.relay.android.domain.model

import java.time.LocalDate
import java.time.OffsetDateTime

data class RelayModel(
    val id: Long,
    val type: String,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime,
    val nextCheckDate: LocalDate
)
