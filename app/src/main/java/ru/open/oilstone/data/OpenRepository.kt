package ru.open.oilstone.data

import android.arch.lifecycle.LiveData
import io.reactivex.Single
import ru.open.oilstone.entities.*
import ru.open.oilstone.models.CardBlock

interface OpenRepository {

    fun getCardBlock(): LiveData<CardBlock>

    fun getCard(): Single<Card>

    fun getBalance(cardId: Long): Single<Balance>

    fun getTransactions(cardId: Long): Single<List<Transaction>>

    fun getSubscriptions(cardId: Long): LiveData<List<Subscription>>

    fun getSubscription(cardId: Long, subscriptionId: Long): LiveData<Subscription>

    fun updateSubscription(cardId: Long, subscriptionId: Long, activeStatus: Boolean, maxCost: Double, comment: Comment?): LiveData<Subscription>
}
