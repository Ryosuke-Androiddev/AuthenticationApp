package com.example.authentication.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.authentication.domain.repository.DataStoreRepository
import com.example.authentication.util.NetworkConstants.PREFERENCES_SIGNED_IN_STATE_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import okio.IOException
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
): DataStoreRepository {

    private object PreferencesKey {
        val signedInStateKey = booleanPreferencesKey(name = PREFERENCES_SIGNED_IN_STATE_KEY)
    }

    override suspend fun saveSignedInState(signedInState: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.signedInStateKey] = signedInState
        }
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val signedInState = preferences[PreferencesKey.signedInStateKey] ?: false
                signedInState
            }
    }
}