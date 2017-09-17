package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class SubscriptionResponse(
        @SerializedName("ErrorCode") val errorCode: Int = 0,
        @SerializedName("ErrorDescription") val errorDescription: String = "",
        @SerializedName("CardSubscribtionDetailsById") val subscription: Subscription?
)