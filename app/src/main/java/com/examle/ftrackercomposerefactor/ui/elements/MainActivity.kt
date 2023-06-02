package com.examle.ftrackercomposerefactor.ui.elements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.examle.ftrackercomposerefactor.FallWorkingDirectory.SensorTrack
import com.examle.ftrackercomposerefactor.FallWorkingDirectory.TrackDelper
import com.examle.ftrackercomposerefactor.ui.theme.FtrackerComposeRefactorTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TrackDelper.initiate(this)
        //SensorTrack.instance(this)
        setContent {
            val isOnboardingPassed = mainViewModel.isOnboardingPassed.collectAsState(null)

            FtrackerComposeRefactorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    isOnboardingPassed.value?.let {
                        if (it) {

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