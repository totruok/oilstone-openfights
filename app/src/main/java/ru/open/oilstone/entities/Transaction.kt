package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class Transaction(
        @SerializedName("TransactionCur") val transactionCur: String,
        @SerializedName("TransactionPlace") val transactionPlace: String?,
        @SerializedName("TransactionDate") val transactionDate: String,
        @SerializedName("TransactionSum") val transactionSum: Int
)
