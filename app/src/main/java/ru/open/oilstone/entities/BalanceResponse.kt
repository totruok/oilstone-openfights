package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class BalanceResponse(
        @SerializedName("ErrorCode") val errorCode: Int = 0,
        @SerializedName("ErrorDescription") val errorDescription: String = "",
        @SerializedName("BalanceEntity") val cardBalance: List<BalanceEntity>?,
        @SerializedName("CardId") val cardId: Int?
)
