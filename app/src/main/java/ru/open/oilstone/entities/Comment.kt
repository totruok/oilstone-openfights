package ru.open.oilstone.entities

import com.google.gson.annotations.SerializedName

data class Comment(
        @SerializedName("text") val text: String = "",
        @SerializedName("user") val user: String = ""
)
