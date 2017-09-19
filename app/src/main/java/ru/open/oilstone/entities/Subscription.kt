package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class Subscription(
        @SerializedName("id") val id: Long,
        @SerializedName("first_payment") val firstPayment: Double,
        @SerializedName("max_cost") val maxCost: Double,
        @SerializedName("cost") val cost: String? = null,
        @SerializedName("comments") var comments: MutableList<Comment> = mutableListOf(),
        @SerializedName("name") val name: String = "",
        @SerializedName("description") val description: String = "",
        @SerializedName("logo") val logo: String?,
        @SerializedName("payment_days") val paymentDays: List<Int> = emptyList(),
        @SerializedName("recomendations") val recommendations: List<Recommendation>? = emptyList(),
        @SerializedName("stars") val stars: Int?,
        @SerializedName("active") var active: Boolean,
        @SerializedName("total_payed") val totalPayed: Double

)
