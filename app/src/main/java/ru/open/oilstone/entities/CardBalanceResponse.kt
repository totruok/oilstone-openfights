package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class CardBalanceResponse(
        @SerializedName("ErrorCode") val errorCode: Int = 0,
        @SerializedName("ErrorDescription") val errorDescription: String = "",
        @SerializedName("CardBalance") val cardBalance: List<CardBalance?>?,
        @SerializedName("CardId") val cardId: Int?
)
