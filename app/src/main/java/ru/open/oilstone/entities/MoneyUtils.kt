package ru.open.oilstone.entities

import java.text.NumberFormat
import java.util.*


object MoneyUtils {

    fun moneyFormat(currency: String?, value: Double, divider: Float = 100f): String {
        val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
        format.currency = Currency.getInstance(currency ?: "RUB")
        return format.format(value.div(divider))
    }
}