package com.examle.ftrackercomposerefactor.ui.elements

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val _isOnboardingPassed = MutableStateFlow(false)
    val isOnboardingPassed: Flow<Boolean>
        get() = _isOnboardingPassed

    fun setOnboardingCompeted() {
        viewModelScope.launch {
            _isOnboardingPassed.emit(true)
        }
    }
}