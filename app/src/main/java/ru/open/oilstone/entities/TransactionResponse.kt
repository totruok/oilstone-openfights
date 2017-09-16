package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class TransactionResponse(
        @SerializedName("ErrorCode") val errorCode: Int = 0,
        @SerializedName("ErrorDescription") val errorDescription: String = "",
        @SerializedName("CardId") val cardId: Int,
        @SerializedName("CardTransactionsList") val cardTransactionsList: List<Transaction>
)
