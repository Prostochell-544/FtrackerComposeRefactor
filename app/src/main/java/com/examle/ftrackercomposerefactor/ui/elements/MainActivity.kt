package com.examle.ftrackercomposerefactor.ui.elements

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.ftrackercomposerefactor.FallWorkingDirectory.SensorTrack
import com.examle.ftrackercomposerefactor.FallWorkingDirectory.TrackDelper
import com.examle.ftrackercomposerefactor.ui.theme.FtrackerComposeRefactorTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity() : ComponentActivity(), Parcelable {
    val mainViewModel by viewModels<MainViewModel>()

    constructor(parcel: Parcel) : this() {
    }

    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //SensorTrack.instance(this)
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
                        verticalArrangement = Arrangement.spacedBy(148.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        isOnboardingPassed.value?.let {
                            if (it) {
                                isMessagingEnabled.value?.let { isMessagingEnabled ->
                                    SwitchWithLabel(
                                        label = "Test",
                                        state = isMessagingEnabled,
                                        onStateChange = { newState ->
                                            mainViewModel.updateMessagingEnabledStatus(newState)
                                        }
                                    )
                                    EditText()
                                    AcceptButton(text = "Assert", onClick = { text ->
                                        println(text)
                                    })
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

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}

@Composable
private fun MyUI() {

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FtrackerComposeRefactorTheme {
        Greeting("Android")
    }
}