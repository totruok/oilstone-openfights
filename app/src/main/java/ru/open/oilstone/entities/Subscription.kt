package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class Subscription(
        @SerializedName("Id") val id: String,
        @SerializedName("Logo") val logo: String,
        @SerializedName("Name") val name: String
)