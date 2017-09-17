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
        fun onDepositClicked(cardId: Long)
        fun onPurchasedClicked(cardId: Long)
        fun onSubscriptionsClicked(cardId: Long)
        fun onSubscriptionClicked(cardId: Long, subscriptionId: Long)
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
                callbacks.onSubscriptionsClicked(data.card.cardId)
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
                clickListener { _, _, _, _ ->
                    if (transaction.transactionSubscrition != null) {
                        callbacks.onSubscriptionClicked(data.card.cardId, transaction.transactionSubscrition.id)
                    }
                }
            }
        }
    }


}
