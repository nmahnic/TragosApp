package com.tragosapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(
    val image: String = "",
    val nombre: String = "",
    val descripcion: String = ""
) : Parcelable