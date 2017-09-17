package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName
import ru.open.oilstone.R

data class Transaction(
        val transactionOwner: String = "",
        val transactionPhotoUrl: String = "",
        @SerializedName("TransactionCur") val transactionCur: String = "RUB",
        @SerializedName("TransactionPlace") val transactionPlace: String = "",
        @SerializedName("TransactionDate") val transactionDate: String,
        @SerializedName("TransactionSum") val transactionSum: Double,
        val transactionSubscrition: Subscription?
) {

    fun colorTransaction(): Int {
        if (transactionSubscrition != null) {
            return if (transactionSubscrition.active) {
                R.color.open_b2
            } else {
                R.color.open_b6
            }
        }
        return 0
    }

    fun isCanceled(): Boolean {
        if (transactionSubscrition != null) {
            return !transactionSubscrition.active
        }
        return false
    }

    fun colorTime(): Int {
        if (transactionSubscrition != null) {
            return android.R.color.white
        }
        return R.color.open_b2
    }

    fun colorOther(): Int {
        if (transactionSubscrition != null) {
            return android.R.color.white
        }
        return R.color.open_b1
    }
}
