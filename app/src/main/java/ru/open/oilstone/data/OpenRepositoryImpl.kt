package ru.open.oilstone.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.open.oilstone.entities.*
import ru.open.oilstone.models.CardBlock

class OpenRepositoryImpl(private val openApi: OpenApi) : OpenRepository {

    override fun getCardBlock(): LiveData<CardBlock> {
        val data = MutableLiveData<CardBlock>()

        getCard().map {
            val balance = getBalance(it.cardId).blockingGet()
            val transactions = getTransactions(it.cardId).blockingGet()
            CardBlock(it, balance, transactions)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    data.value = it
                }, {
                    it.printStackTrace()
                })
        return data
    }


    override fun getSubscriptions(cardId: Long): LiveData<List<Subscription>> {
        val data = MutableLiveData<List<Subscription>>()
        val body = mapOf("CardId" to cardId)

        Log.d("API", "startLoading")
        openApi.subscriptions(body).map {
            it.subscriptions
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    data.value = it
                }, {
                    it.printStackTrace()
                })
        return data
    }

    override fun getCard(): Single<Card> {
        return openApi.cards().map { it.cards[0] }
    }

    override fun getBalance(cardId: Long): Single<Balance> {
        val body = mapOf("CardId" to cardId)
        return openApi.balance(body).map { it.cardBalance[0] }
    }

    override fun getTransactions(cardId: Long): Single<List<Transaction>> {
        val body = mapOf("CardId" to cardId)
        return openApi.history(body).map { it.cardTransactionsList }
    }

    override fun getSubscription(cardId: Long, subscriptionId: Long): LiveData<Subscription> {
        val data = MutableLiveData<Subscription>()
        val body = mapOf("CardId" to cardId.toString(), "subs_id" to subscriptionId.toString())

        openApi.subscription(body).map { it.subscription!! }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    data.value = it
                }, {
                    it.printStackTrace()
                })
        return data
    }

    override fun updateSubscription(cardId: Long, subscriptionId: Long, activeStatus: Boolean, maxCost: Double, comment: Comment?): LiveData<Subscription> {
        val data = MutableLiveData<Subscription>()
        val body = mapOf("CardId" to cardId.toString(), "subs_id" to subscriptionId.toString())

        openApi.subscriptionSetSettings(body).map { it.subscription!! }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    data.value = it
                }, {
                    it.printStackTrace()
                })
        return data
    }
}
