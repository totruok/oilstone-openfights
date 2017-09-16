package ru.open.oilstone.data

import android.arch.lifecycle.LiveData
import io.reactivex.Single
import ru.open.oilstone.entities.*
import ru.open.oilstone.models.CardBlock

interface OpenRepository {

    fun getCardBlock(): LiveData<CardBlock>

    fun getCard(): Single<Card>

    fun getBalance(cardId: Int): Single<Balance>

    fun getTransactions(cardId: Int): Single<List<Transaction>>

    fun getSubscriptions(): LiveData<List<Subscription>>

    fun getSubscriptionDetail(): Single<SubscriptionDetail>

    fun getSubscriptionSetting(settings: SubscriptionSettings): Single<SubscriptionSettingsResponse>
}
