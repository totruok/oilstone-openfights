package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class Card(
        @SerializedName("CardId") val cardId: Int,
        @SerializedName("CardName") val cardName: String,
        private @SerializedName("CardPaymentSystem") val cardPaymentSystem: String,
        private @SerializedName("CardType") val cardType: String
) {
    fun getCardTitle(): String = "${getType()} $cardId"

    private fun getType() = when (cardPaymentSystem) {
        "visa" -> {
            "Visa"
        }
        "master" -> {
            "MasterCard"
        }
        "mir" -> {
            "Mir"
        }
        else -> {
            ""
        }
    }

}
