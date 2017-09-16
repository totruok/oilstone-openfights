package ru.open.oilstone.domain.entities

data class CardTransactionResponse(
    val errorCode: Int = 0,
	val errorDescription: String = "",
	val cardId: Int,
	val cardTransactionsList: List<CardTransaction>
)
