package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class Transaction(
        val transactionOwner: String = "",
        val transactionPhotoUrl: String = "",
        @SerializedName("TransactionCur") val transactionCur: String = "RUB",
        @SerializedName("TransactionPlace") val transactionPlace: String = "",
        @SerializedName("TransactionDate") val transactionDate: String,
        @SerializedName("TransactionSum") val transactionSum: Double
)
