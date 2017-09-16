package ru.open.oilstone.entities

data class CardBalanceResponse(
        val errorCode: Int = 0,
        val errorDescription: String = "",
        val cardBalance: List<CardBalance?>?,
        val cardId: Int?
)
