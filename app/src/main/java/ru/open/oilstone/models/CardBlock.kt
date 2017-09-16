package ru.open.oilstone.models

import ru.open.oilstone.entities.Balance
import ru.open.oilstone.entities.Card
import ru.open.oilstone.entities.Transaction

data class CardBlock(
        val card: Card,
        val balance: Balance,
        val transactions: List<Transaction>
)
