package com.relay.android.domain.repository

import com.relay.android.domain.model.RelayModel

interface RelayRepository {
    suspend fun getAllRelays(): List<RelayModel>
}