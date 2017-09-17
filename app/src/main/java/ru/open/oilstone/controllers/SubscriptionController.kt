package ru.open.oilstone.controllers

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController
import ru.open.oilstone.R
import ru.open.oilstone.entities.MoneyUtils
import ru.open.oilstone.entities.Subscription
import ru.open.oilstone.holders.*

class SubscriptionController(private val callbacks: SubscriptionController.AdapterCallbacks) : TypedEpoxyController<Subscription>() {
    lateinit var context: Context

    interface AdapterCallbacks {
        fun onToggleActive(subscriptions: Subscription, active: Boolean)
        fun onSendMessage(subscriptions: Subscription, message: String)
        fun onChangeLimit(subscriptions: Subscription, maxPrice: Double)
        fun onClickUrl(url: String)
    }

    override fun buildModels(subscription: Subscription) {
        var id = 0
        subscriptionModelHolder {
            id(id++)
            avatar(subscription.logo ?: "")
            name(subscription.name)
            canceled(!subscription.active)
            summary(context.getString(R.string.summary_n, MoneyUtils.moneyFormat("RUB", subscription.firstPayment)))
            description(subscription.description)
            detail(true)
            rating(context.getString(R.string.rating_n, subscription.stars.toString()))
            totalSummary(context.getString(R.string.summary_total_n, MoneyUtils.moneyFormat("RUB", subscription.totalPayed)))
        }
        toggleModelHolder {
            id(id++)
            active(!subscription.active)
            onCheckedListener { buttonView, isChecked ->
                callbacks.onToggleActive(subscription, isChecked)
            }
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
        editModelHolder {
            id(id++)
            submitListener(object : EditModelHolder.AdapterCallbacks {
                override fun onSumbit(text: String) {
                    callbacks.onSendMessage(subscription, text)
                }
            }
            )
        }
        titleModelHolder {
            id(id++)
            textRes(R.string.title_recommend)
        }
        if (subscription.recommendations != null) {
            for (i in 0 until subscription.recommendations.size) {
                recomendModelHolder {
                    id(id++)
                    logo(subscription.recommendations[i].logo!!)
                    name(subscription.recommendations[i].name)
                    description(subscription.recommendations[i].description)
                    clickListener { model, parentView, clickedView, position ->
                        callbacks.onClickUrl(subscription.recommendations[i].url!!)
                    }
                }
            }
        }

//        for (i in 0 until subscription.recommendations.size) {
//            subscriptionModelHolder {
//                id(id++)
//                avatar(subscription.recommendations[i].logo ?: "")
//                name(subscription.recommendations[i].name)
////            clickListener { _, _, _, _ ->
////                val subscription = subscription.recommendations[i][i]
////                callbacks.onSubscriptionClicked(subscription)
////            }
//                canceled(!subscription.recommendations[i].active)
//                summary(context.getString(R.string.summary_n, MoneyUtils.moneyFormat("RUB", subscription.recommendations[i].firstPayment)))
//                description(subscription.recommendations[i].description)
//                detail(false)
//            }
//        }
    }


}