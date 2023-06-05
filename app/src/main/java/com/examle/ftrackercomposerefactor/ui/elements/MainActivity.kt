package com.examle.ftrackercomposerefactor.ui.elements

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.examle.ftrackercomposerefactor.ui.theme.FtrackerComposeRefactorTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@SuppressLint("ParcelCreator")
class MainActivity() : ComponentActivity(), Parcelable {
    val mainViewModel by viewModels<MainViewModel>()
    val mainPage = MainPage()

    constructor(parcel: Parcel) : this() {
    }
    companion object {
        private const val COARSE_PERMISSION_CODE = 100
        private const val FINE_PERMISSION_CODE = 101
        private const val AUDIO_PERMISSION_CODE = 102
        private const val CONTACTS_PERMISSION_CODE = 103
        private const val PHONE_PERMISSION_CODE = 104
        private const val BOOT_PERMISSION_CODE = 105
        private const val RECEIVE_PERMISSION_CODE = 106
        private const val SEND_PERMISSION_CODE = 107
        private const val FOREGROUND_PERMISSION_CODE = 108
        private const val SENSORS_PERMISSION_CODE = 109
        private const val WAKE_PERMISSION_CODE = 110
    }
    @RequiresApi(Build.VERSION_CODES.P)
    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            val isOnboardingPassed = mainViewModel.isOnboardingPassed.collectAsState(null)
            val isMessagingEnabled =
                mainViewModel.isMessagingEnabled.collectAsState(initial = false)
            var getPhoneNumber by remember { mutableStateOf("") }
            FtrackerComposeRefactorTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        isOnboardingPassed.value?.let {
                            if (it) {
                                checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION,COARSE_PERMISSION_CODE)
                                checkPermission(Manifest.permission.ACCESS_FINE_LOCATION,FINE_PERMISSION_CODE)
                                checkPermission(Manifest.permission.MODIFY_AUDIO_SETTINGS,AUDIO_PERMISSION_CODE)
                                checkPermission(Manifest.permission.READ_CONTACTS,CONTACTS_PERMISSION_CODE)
                                checkPermission(Manifest.permission.READ_PHONE_STATE,PHONE_PERMISSION_CODE)
                                checkPermission(Manifest.permission.RECEIVE_BOOT_COMPLETED,BOOT_PERMISSION_CODE)
                                checkPermission(Manifest.permission.RECEIVE_SMS,RECEIVE_PERMISSION_CODE)
                                checkPermission(Manifest.permission.SEND_SMS,SEND_PERMISSION_CODE)
                                checkPermission(Manifest.permission.FOREGROUND_SERVICE,FOREGROUND_PERMISSION_CODE)
                                checkPermission(Manifest.permission.BODY_SENSORS,SENSORS_PERMISSION_CODE)
                                isMessagingEnabled.value?.let { isMessagingEnabled ->
                                    mainPage.SwitchWithLabel(
                                        label = "Запуск работы датчиков",
                                        state = isMessagingEnabled,
                                        onStateChange = { newState ->
                                            mainViewModel.updateMessagingEnabledStatus(newState)
                                        }
                                    )
                                    mainPage.PhoneNumberInput()
                                }
                            } else {
                                OnBoarding {
                                    mainViewModel.setOnboardingCompeted()
                                }

                            }
                        }
                    }
                }
            }
        }
    }
    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                permission
            ) == PackageManager.PERMISSION_DENIED
        ) {
            // Requesting the permission
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT)
                .show()
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == COARSE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#100 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#100 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        } else if (requestCode == FINE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#101 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#101 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == AUDIO_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#102 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#102 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == CONTACTS_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#103 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#103 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == PHONE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#104 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#104 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == BOOT_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#105 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#105 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == RECEIVE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#106 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#106 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }else if (requestCode == SEND_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#107 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#107 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == FOREGROUND_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#108 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#108 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == SENSORS_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#109 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#109 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == WAKE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "#110 Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "#110 Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

        object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
