package ru.open.oilstone.domain.entities

data class CardTransaction(
	val transactionCur: String,
	val transactionPlace: String,
	val transactionDate: String,
	val transactionSum: Int
)
