package ru.open.oilstone.data

import io.reactivex.Single
import ru.open.oilstone.entities.*

interface OpenRepository {

    fun getCards(): Single<List<Card>>

    fun getBalance(): Single<Balance>

    fun getTransacrtions(): Single<List<Transaction>>

    fun getSubscriptons(): Single<List<Subscription>>

    fun getSubscriptonDetail(): Single<SubscriptionDetail>
}
