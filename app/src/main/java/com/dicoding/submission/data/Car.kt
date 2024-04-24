package com.dicoding.submission.bmaap.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable