package ru.open.oilstone.controllers

import com.airbnb.epoxy.TypedEpoxyController
import ru.open.oilstone.R
import ru.open.oilstone.entities.MoneyUtils
import ru.open.oilstone.holders.buttonModelHolder
import ru.open.oilstone.holders.cardModelHolder
import ru.open.oilstone.holders.invoiceModelHolder
import ru.open.oilstone.models.CardBlock

class CardController(private val callbacks: CardController.AdapterCallbacks) : TypedEpoxyController<CardBlock>() {
    interface AdapterCallbacks {
        fun onDepositClicked()
        fun onPurchasedClicked()
        fun onSubscriptionsClicked()
    }

    override fun buildModels(data: CardBlock) {
        cardModelHolder {
            id(data.card.cardId)
            name(data.card.getCardTitle())
            balance(MoneyUtils.moneyFormat(data.balance.cur, data.balance.value))
        }
        buttonModelHolder {
            id(1)
            textRes(R.string.action_subscriptions)
            clickListener { _, _, _, _ ->
                callbacks.onSubscriptionsClicked()
            }
        }
        for (transaction in data.transactions) {
            invoiceModelHolder {
                id(transaction.hashCode())
                date(transaction.transactionDate)
                timeColor(transaction.colorTime())
                avatar(transaction.transactionPhotoUrl)
                name(transaction.transactionOwner)
                description(transaction.transactionPlace)
                otherTextColor(transaction.colorOther())
                canceled(transaction.isCanceled())
                summary(MoneyUtils.moneyFormat(transaction.transactionCur, transaction.transactionSum))
                bgResColor(transaction.colorTransaction())
            }
        }
    }


}
