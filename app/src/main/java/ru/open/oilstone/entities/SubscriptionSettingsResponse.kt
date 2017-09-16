package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class SubscriptionSettingsResponse(
        @SerializedName("ErrorCode") val errorCode: Int = 0,
        @SerializedName("ErrorDescription") val errorDescription: String = ""
)