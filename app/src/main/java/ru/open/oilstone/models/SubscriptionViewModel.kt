package ru.open.oilstone.models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import ru.open.oilstone.data.OpenRepository
import ru.open.oilstone.entities.Comment
import ru.open.oilstone.entities.Subscription

class SubscriptionViewModel constructor(val repository: OpenRepository) : ViewModel() {

    var cardId: Long? = null
    var subscriptionId: Long? = null

    fun setIds(cardId: Long, subId: Long) {
        if (subscription != null && this.cardId == cardId && this.subscriptionId == subId) {
            return
        }
        this.cardId = cardId
        this.subscriptionId = subId
        subscription = repository.getSubscription(cardId, subId)
    }

    fun setUpdate(active: Boolean, maxCost: Double, comment: Comment?): LiveData<Subscription> {
        return repository.updateSubscription(cardId!!, subscriptionId!!, active, maxCost, comment)
    }

    var subscription: LiveData<Subscription>? = null

    companion object {
        fun create(fragment: Fragment, factory: ViewModelProvider.Factory): SubscriptionViewModel {
            return ViewModelProviders.of(fragment, factory).get(SubscriptionViewModel::class.java)
        }
    }

}