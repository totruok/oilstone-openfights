package ru.open.oilstone.entities

data class Subscription(
        val firstPayment: String = "",
        val cost: String? = null,
        val comments: List<Comment> = emptyList(),
        val name: String = "",
        val description: String = "",
        val logo: String?,
        val paymentDays: List<Double> = emptyList(),
        val liveTimeMonths: Int = 3,
        val recommendations: List<Recommendation> = emptyList(),
        val stars: Int?
)
