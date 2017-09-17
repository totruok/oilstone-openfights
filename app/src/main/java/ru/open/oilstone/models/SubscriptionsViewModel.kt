package ru.open.oilstone.models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import ru.open.oilstone.data.OpenRepository
import ru.open.oilstone.entities.Subscription

class SubscriptionsViewModel constructor(val repository: OpenRepository) : ViewModel() {

    var cardId: Long? = null

    fun setId(cardId: Long) {
        if (subscriptions != null && this.cardId == cardId) {
            return
        }
        this.cardId = cardId
        subscriptions = repository.getSubscriptions(cardId)
    }

    var subscriptions: LiveData<List<Subscription>>? = null

    companion object {
        fun create(fragment: Fragment, factory: ViewModelProvider.Factory): SubscriptionsViewModel {
            return ViewModelProviders.of(fragment, factory).get(SubscriptionsViewModel::class.java)
        }
    }

}