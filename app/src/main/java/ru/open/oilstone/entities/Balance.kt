package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName
import java.text.NumberFormat
import java.util.*

data class Balance(
        @SerializedName("Cur") val cur: String?,
        @SerializedName("Value") val value: Int?
) {
    fun balance(): String {
        val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
        format.currency = Currency.getInstance(cur)
        return format.format(value)
    }
}
