package ru.open.oilstone.controllers

import com.airbnb.epoxy.TypedEpoxyController
import ru.open.oilstone.entities.Subscription
import ru.open.oilstone.holders.subscriptionModelHolder

class SubscriptionsController(private val callbacks: SubscriptionsController.AdapterCallbacks) : TypedEpoxyController<List<Subscription>>() {
    interface AdapterCallbacks {
        fun onSubscriptionClicked(subscription: Subscription)
    }

    override fun buildModels(subscriptions: List<Subscription>) {
        for (i in 0 until subscriptions.size) {
            subscriptionModelHolder {
                id(i)
                avatar(subscriptions[i].logo ?: "")
                name(subscriptions[i].name)
                clickListener { model, parentView, clickedView, position ->
                    val subscription = subscriptions[i]
                    callbacks.onSubscriptionClicked(subscription)
                }

            }
        }
//        subscriptionModelHolder {
//            id(su)
//        }
    }


}