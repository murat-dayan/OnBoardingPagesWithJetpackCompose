package com.muratdayan.onboardingscreen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.muratdayan.onboardingscreen.onboarding.OnBoardingScreen
import com.muratdayan.onboardingscreen.onboarding.OnBoardingUtils
import com.muratdayan.onboardingscreen.ui.theme.OnBoardingScreenTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val onBoardingUtils by lazy {
        OnBoardingUtils(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            OnBoardingScreenTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    if(onBoardingUtils.isOnBoardingComplete()){
                        ShowHomeScreen()
                    }else{
                        ShowOnBoardingScreen()
                    }
                }
            }
        }
    }

    @Composable
    private fun ShowHomeScreen(){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Home Screen", style = MaterialTheme.typography.headlineLarge)
        }
    }


    @Composable
    private fun ShowOnBoardingScreen(){
        val scope = rememberCoroutineScope()

        OnBoardingScreen {
            onBoardingUtils.setOnBoardingComplete()
            scope.launch {
                setContent {
                    ShowHomeScreen()
                }
            }
        }
    }

}


