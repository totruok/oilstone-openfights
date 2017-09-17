package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class Subscription(
        @SerializedName("first_payment") val firstPayment: Double,
        @SerializedName("max_cost") val maxCost: Double,
        @SerializedName("cost") val cost: String? = null,
        @SerializedName("comments") val comments: List<Comment> = emptyList(),
        @SerializedName("name") val name: String = "",
        @SerializedName("description") val description: String = "",
        @SerializedName("logo") val logo: String?,
        @SerializedName("payment_days") val paymentDays: List<Int> = emptyList(),
        @SerializedName("recommendations") val recommendations: List<Recommendation> = emptyList(),
        @SerializedName("stars") val stars: Int?
)
