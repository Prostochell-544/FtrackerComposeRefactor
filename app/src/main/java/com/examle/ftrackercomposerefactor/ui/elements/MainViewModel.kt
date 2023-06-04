package com.examle.ftrackercomposerefactor.ui.elements

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.examle.ftrackercomposerefactor.FallHelpDirectory.DataStoreConst
import com.examle.ftrackercomposerefactor.FallWorkingDirectory.TrackDelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val dataStoreConst = DataStoreConst(application.applicationContext)
    val _isOnboardingPassed = dataStoreConst.isOnboardingPassedFlow
    val isOnboardingPassed: Flow<Boolean?>
        get() = _isOnboardingPassed

    val _isMessagingEnabled = dataStoreConst.isMessagingEnabledFlow
    val isMessagingEnabled: Flow<Boolean?>
        get() = _isOnboardingPassed

    init {
        viewModelScope.launch {
            if (isOnboardingPassed.first() == null) {
                setOnboardingUncompleted()
            }

            if (isMessagingEnabled.first() == null) {
                updateMessagingEnabledStatus(false)
            }
        }
    }

    fun setOnboardingCompeted() {
        viewModelScope.launch {
            dataStoreConst.updateOnboardingPassedStatus(true)
        }
    }

    fun setOnboardingUncompleted() {
        viewModelScope.launch {
            dataStoreConst.updateOnboardingPassedStatus(false)
        }
    }

    fun updateMessagingEnabledStatus(status: Boolean) {
        viewModelScope.launch {
            dataStoreConst.updateMessagingEnabledStatus(status)
        }

        if (status) {
            TrackDelper.initiate(getApplication())
        } else {
            TrackDelper.stop(getApplication())
        }
    }
}