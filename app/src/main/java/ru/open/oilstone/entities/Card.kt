package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class Card(
        @SerializedName("CardName") val cardName: String,
        @SerializedName("CardPaymentSystem") val cardPaymentSystem: String,
        @SerializedName("CardType") val cardType: String,
        @SerializedName("CardId") val cardId: Int
)
