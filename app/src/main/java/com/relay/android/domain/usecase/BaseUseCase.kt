package com.relay.android.domain.usecase

abstract class BaseUseCase<T> {
    abstract suspend fun invoke(): T
}