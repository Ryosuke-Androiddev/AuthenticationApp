package com.example.authentication.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun saveSignedInState(signedInState: Boolean)
    fun readSignedInState(): Flow<Boolean>
}