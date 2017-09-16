package ru.open.oilstone.domain.entities

data class CardsResponse(
    val errorCode: Int = 0,
    val errorDescription: String = "",
	val cards: List<Cards>
)
