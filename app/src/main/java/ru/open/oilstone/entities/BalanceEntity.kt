package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class BalanceEntity(
        @SerializedName("Cur") val cur: String?,
        @SerializedName("Value") val value: Int?
)
