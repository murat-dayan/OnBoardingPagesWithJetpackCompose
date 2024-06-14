package com.muratdayan.onboardingscreen.onboarding

import androidx.annotation.DrawableRes
import com.muratdayan.onboardingscreen.R

sealed class OnBoardingModel(
    @DrawableRes val image:Int,
    val title:String,
    val description:String
){
    data object FirstPages : OnBoardingModel(
        image = R.drawable.img1,
        title = "First Page",
        description = "This is the first page description"
    )

    data object SecondPages : OnBoardingModel(
        image = R.drawable.img2,
        title = "Second Page",
        description = "This is the second page description"
    )

    data object ThirdPages : OnBoardingModel(
        image = R.drawable.img3,
        title = "Third Page",
        description = "This is the third page description"
    )
}