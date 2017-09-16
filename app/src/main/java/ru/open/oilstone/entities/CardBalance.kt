package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class CardBalance(
        @SerializedName("Cur") val cur: String?,
        @SerializedName("Value") val value: Int?
)
