package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class SubscriptionsResponse(
        @SerializedName("ErrorCode") val errorCode: Int = 0,
        @SerializedName("ErrorDescription") val errorDescription: String = "",
        @SerializedName("CardId") val cardId: String = "",
        @SerializedName("CardSubscribtionsList") val subscriptions: List<Subscription> = emptyList()
)