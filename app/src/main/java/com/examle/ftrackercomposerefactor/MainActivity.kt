package com.examle.ftrackercomposerefactor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.examle.ftrackercomposerefactor.ui.theme.FtrackerComposeRefactorTheme
import com.examle.ftrackercomposerefactor.ui.theme.OnBoarding
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    val isOnboardingPassed = viewModel.isOnboardingPassed.collectAsState()
//https://habr.com/ru/companies/tinkoff/articles/525010/
    //https://stackoverflow.com/questions/67768746/chaining-modifier-based-on-certain-conditions-in-android-compose
    //https://www.answertopia.com/jetpack-compose/a-jetpack-compose-viewmodel-tutorial/
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FtrackerComposeRefactorTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    if isOnboardingPassed {
                        Greeting(name = )
                    } else {
                        OnBoarding()
                    }
                }
            }
        }
    }
}

//Дизайн это ложь
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