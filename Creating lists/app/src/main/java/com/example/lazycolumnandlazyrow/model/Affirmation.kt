package com.example.lazycolumnandlazyrow.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation (
    @StringRes val name: Int,
    val availableCourses: Int,
    @DrawableRes val imageResource: Int
)