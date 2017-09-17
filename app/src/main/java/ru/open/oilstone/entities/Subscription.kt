package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class Subscription(
        val firstPayment: Int = 0,
        val maxCost: Double,
        val cost: String? = null,
        val comments: List<Comment> = emptyList(),
        @SerializedName("name") val name: String = "",
        @SerializedName("description") val description: String = "",
        @SerializedName("logo") val logo: String?,
        val paymentDays: List<Int> = emptyList(),
        val liveTimeMonths: Int = 3,
        val recommendations: List<Recommendation> = emptyList(),
        val stars: Int?
)
