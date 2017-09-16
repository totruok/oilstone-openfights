package ru.open.oilstone.data

import io.reactivex.Single
import ru.open.oilstone.entities.*

class OpenRepositoryImpl(val openApi: OpenApi) : OpenRepository {
    override fun getCards(): Single<List<CardEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBalance(): Single<BalanceEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTransactions(): Single<List<TransactionEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSubscriptions(): Single<List<SubscriptionEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSubscriptionDetail(): Single<SubscriptionDetailEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSubscriptionSetting(settings: SubscriptionSettings): Single<SubscriptionSettingsResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
