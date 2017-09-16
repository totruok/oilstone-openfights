package ru.open.oilstone.data

import io.reactivex.Single
import ru.open.oilstone.entities.*

interface OpenRepository {

    fun getCards(): Single<List<CardEntity>>

    fun getBalance(): Single<BalanceEntity>

    fun getTransactions(): Single<List<TransactionEntity>>

    fun getSubscriptions(): Single<List<SubscriptionEntity>>

    fun getSubscriptionDetail(): Single<SubscriptionDetailEntity>

    fun getSubscriptionSetting(settings: SubscriptionSettings): Single<SubscriptionSettingsResponse>
}
