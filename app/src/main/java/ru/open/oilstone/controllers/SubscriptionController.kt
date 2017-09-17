package ru.open.oilstone.controllers

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController
import ru.open.oilstone.R
import ru.open.oilstone.entities.MoneyUtils
import ru.open.oilstone.entities.Subscription
import ru.open.oilstone.holders.messageModelHolder
import ru.open.oilstone.holders.subscriptionModelHolder
import ru.open.oilstone.holders.titleModelHolder

class SubscriptionController(private val callbacks: SubscriptionController.AdapterCallbacks) : TypedEpoxyController<Subscription>() {
    lateinit var context: Context

    interface AdapterCallbacks {
        fun onToggleActive(subscriptions: Subscription, active: Boolean)
        fun onSendMessage(subscriptions: Subscription, message: String)
        fun onChangeLimit(subscriptions: Subscription, maxPrice: Double)
    }

    override fun buildModels(subscription: Subscription) {
        var id = 0
        subscriptionModelHolder {
            id(id++)
            avatar(subscription.logo ?: "")
            name(subscription.name)
            canceled(subscription.active)
            summary(context.getString(R.string.summary_n, MoneyUtils.moneyFormat("RUB", subscription.firstPayment)))
            description(subscription.description)
            detail(true)
            rating(context.getString(R.string.rating_n, subscription.stars.toString()))
            totalSummary(context.getString(R.string.summary_total_n, MoneyUtils.moneyFormat("RUB", subscription.totalPayed)))
        }
        titleModelHolder {
            id(id++)
            textRes(R.string.title_comments)
        }
        for (i in 0 until subscription.comments.size) {
            messageModelHolder {
                id(id++)
                name(subscription.comments[i].user)
                text(subscription.comments[i].text)
            }
        }
        titleModelHolder {
            id(id++)
            textRes(R.string.title_recommend)
        }
    }


}