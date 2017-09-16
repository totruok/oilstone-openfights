package ru.open.oilstone.domain.entities

data class CardBalanceResponse(
        val cardBalance: List<CardBalance?>? = null,
        val cardId: Int? = null
)
