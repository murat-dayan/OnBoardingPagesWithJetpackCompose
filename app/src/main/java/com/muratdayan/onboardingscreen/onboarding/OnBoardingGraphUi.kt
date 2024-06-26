package com.muratdayan.onboardingscreen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnBoardingGraphUi(onBoardingModel: OnBoardingModel) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(90.dp))

        Image(
            painter = painterResource(id = onBoardingModel.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp),
            alignment = Alignment.Center
        )

        Spacer(modifier = Modifier.size(70.dp))

        Text(
            text = onBoardingModel.title,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.size(10.dp))

        Text(
            text = onBoardingModel.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.size(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingGraphUiPreview1() {
    OnBoardingGraphUi(onBoardingModel = OnBoardingModel.FirstPages)
}

@Preview(showBackground = true)
@Composable
fun OnBoardingGraphUiPreview2() {
    OnBoardingGraphUi(onBoardingModel = OnBoardingModel.SecondPages)
}

@Preview(showBackground = true)
@Composable
fun OnBoardingGraphUiPreview3() {
    OnBoardingGraphUi(onBoardingModel = OnBoardingModel.ThirdPages)
}
