package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class Balance(
        @SerializedName("Cur") val cur: String = "RUB",
        @SerializedName("Value") val value: Double
)
