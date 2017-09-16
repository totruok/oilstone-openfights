package ru.open.oilstone.controllers

import android.support.v7.widget.RecyclerView.RecycledViewPool
import com.airbnb.epoxy.TypedEpoxyController
import ru.open.oilstone.R
import ru.open.oilstone.holders.buttonModelHolder
import ru.open.oilstone.models.CardBlock
import ru.open.oilstone.views.cardView

class CardController(private val callbacks: CardController.AdapterCallbacks, private val recyclerViewPool: RecycledViewPool) : TypedEpoxyController<CardBlock>() {
    interface AdapterCallbacks {
        fun onDepositClicked()
        fun onPurchasedClicked()
        fun onSubscriptionsClicked()
    }

    override fun buildModels(data: CardBlock) {
        cardView {
            id(data.card.cardId)
            name(data.card.getCardTitle())
            balance(data.balance.balance())
        }
        buttonModelHolder {
            id(1)
            textRes(R.string.action_subscriptions)
            clickListener { _, _, _, _ ->
                callbacks.onSubscriptionsClicked()
            }
        }
//        for (transaction in data.transactions) {
//        }
    }


}
