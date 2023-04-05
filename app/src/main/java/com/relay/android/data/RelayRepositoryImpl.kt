package com.relay.android.data

import com.relay.android.domain.model.RelayModel
import com.relay.android.domain.repository.RelayRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.time.LocalDate
import java.time.OffsetDateTime
import kotlin.random.Random

class RelayRepositoryImpl : RelayRepository {

    companion object {
        var count = 0
    }

    override suspend fun getAllRelays(): List<RelayModel> {
        val list: List<RelayModel>
        withContext(Dispatchers.IO) {
            when (count) {
                0 -> {
                    delay(3000)
                    list = emptyList()
                    count++
                }
                1 -> {
                    count++
                    delay(10000)
                    throw ConnectException("Lost internet connection")
                }
                2 -> {
                    delay(5000)
                    list = listOf(
                        RelayModel(
                            id = 1,
                            type = "NMH-400",
                            createdAt = OffsetDateTime.now(),
                            updatedAt = OffsetDateTime.now()
                                .plusMinutes(Random(100).nextLong(10, 100)),
                            nextCheckDate = LocalDate.now().plusMonths(Random(100).nextLong(1, 10))
                        ),
                        RelayModel(
                            id = 2,
                            type = "NMH-400",
                            createdAt = OffsetDateTime.now(),
                            updatedAt = OffsetDateTime.now()
                                .plusMinutes(Random(100).nextLong(10, 100)),
                            nextCheckDate = LocalDate.now().plusMonths(Random(100).nextLong(1, 10))
                        ),
                        RelayModel(
                            id = 3,
                            type = "NMH-400",
                            createdAt = OffsetDateTime.now(),
                            updatedAt = OffsetDateTime.now()
                                .plusMinutes(Random(100).nextLong(10, 100)),
                            nextCheckDate = LocalDate.now().plusMonths(Random(100).nextLong(1, 10))
                        ),
                        RelayModel(
                            id = 4,
                            type = "NMH-400",
                            createdAt = OffsetDateTime.now(),
                            updatedAt = OffsetDateTime.now()
                                .plusMinutes(Random(100).nextLong(10, 100)),
                            nextCheckDate = LocalDate.now().plusMonths(Random(100).nextLong(1, 10))
                        ),
                        RelayModel(
                            id = 5,
                            type = "NMH-400",
                            createdAt = OffsetDateTime.now(),
                            updatedAt = OffsetDateTime.now()
                                .plusMinutes(Random(100).nextLong(10, 100)),
                            nextCheckDate = LocalDate.now().plusMonths(Random(100).nextLong(1, 10))
                        ),
                        RelayModel(
                            id = 6,
                            type = "NMH-400",
                            createdAt = OffsetDateTime.now(),
                            updatedAt = OffsetDateTime.now()
                                .plusMinutes(Random(100).nextLong(10, 100)),
                            nextCheckDate = LocalDate.now().plusMonths(Random(100).nextLong(1, 10))
                        ),
                    )

                }
                else -> {
                    list = emptyList()
                }
            }
            return@withContext list
        }
        return list
    }
}