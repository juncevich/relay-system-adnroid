package com.relay.android.domain.usecase

import com.relay.android.domain.model.RelayModel
import com.relay.android.domain.repository.RelayRepository
import javax.inject.Inject

class LoadRelaysUseCase @Inject constructor(
    private val relayRepository: RelayRepository
) : BaseUseCase<List<RelayModel>>() {

    override suspend fun invoke(): List<RelayModel> = relayRepository.getAllRelays()
}