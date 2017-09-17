package ru.open.oilstone.models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import ru.open.oilstone.data.OpenRepository
import ru.open.oilstone.entities.Subscription

class SubscriptionsViewModel constructor(repository: OpenRepository) : ViewModel() {

    var subscriptions: LiveData<List<Subscription>> = repository.getSubscriptions()
        private set

    companion object {
        fun create(fragment: Fragment, factory: ViewModelProvider.Factory): SubscriptionsViewModel {
            return ViewModelProviders.of(fragment, factory).get(SubscriptionsViewModel::class.java)
        }
    }

}