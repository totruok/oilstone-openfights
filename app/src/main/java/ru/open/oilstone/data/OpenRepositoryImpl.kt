package ru.open.oilstone.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
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

    override fun getSubscriptions(): LiveData<List<Subscription>> {
        val data = MutableLiveData<List<Subscription>>()
        val body = mapOf("CardId" to CARD_ID)
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
        return Single.just(Card(CARD_ID, "Семейная карта", "visa", "debit"))
    }

    override fun getBalance(cardId: Long): Single<Balance> {
        val body = mapOf("CardId" to cardId)
        return openApi.balance(body).map { it.cardBalance[0] }
    }

    override fun getTransactions(cardId: Long): Single<List<Transaction>> {
        val body = mapOf("CardId" to cardId)
        return openApi.history(body).map { it.cardTransactionsList }
    }


    override fun getSubscriptionDetail(): Single<SubscriptionDetail> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSubscriptionSetting(settings: SubscriptionSettings): Single<SubscriptionSettingsResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        val CARD_ID: Long = 9731875055002762
    }
}
