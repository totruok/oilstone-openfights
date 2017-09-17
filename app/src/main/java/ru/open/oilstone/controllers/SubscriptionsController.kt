package ru.open.oilstone.controllers

import com.airbnb.epoxy.TypedEpoxyController
import ru.open.oilstone.entities.Subscription
import ru.open.oilstone.models.CardBlock

class SubscriptionsController(private val callbacks: SubscriptionsController.AdapterCallbacks) : TypedEpoxyController<CardBlock>() {
    interface AdapterCallbacks {
        fun onSubscriptionClicked(subscription: Subscription)
    }

    override fun buildModels(data: CardBlock) {

    }


}