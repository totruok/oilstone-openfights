package ru.open.oilstone.controllers

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController
import ru.open.oilstone.R
import ru.open.oilstone.entities.MoneyUtils
import ru.open.oilstone.entities.Subscription
import ru.open.oilstone.holders.subscriptionModelHolder

class SubscriptionsController(private val callbacks: SubscriptionsController.AdapterCallbacks) : TypedEpoxyController<List<Subscription>>() {
    lateinit var context: Context

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
                summary(context.getString(R.string.summary_n, MoneyUtils.moneyFormat("RUB", subscriptions[i].firstPayment)))
                description(subscriptions[i].description)
            }
        }
//        subscriptionModelHolder {
//            id(su)
//        }
    }


}