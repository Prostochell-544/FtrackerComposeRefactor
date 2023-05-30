package com.examle.ftrackercomposerefactor.FallHelpDirectory

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.emptyPreferences
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreConst(context: Context) {

    private val dataStore = context.createDataStore(name = "prefernce_name")

    val isOnboardingPassedFlow: Flow<Boolean?> = dataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map {
            it[isOnboardingPassed]
        }

    companion object {
        val isOnboardingPassed = preferencesKey<Boolean>("is_it_ps")
    }

    suspend fun updateOnboardingPassedStatus(status: Boolean) {
        dataStore.edit {
            it[isOnboardingPassed] = status
        }
    }
}