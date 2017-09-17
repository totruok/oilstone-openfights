package ru.open.oilstone

import android.os.Bundle
import ru.open.oilstone.base.BaseActivity
class MainActivity : BaseActivity(), MainRouter {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            openCard()
        }
    }

    override fun openCard() {
        replace(CardFragment())
    }

    override fun openSubscriptions(cardId: Long) {
        addBackStack(SubscriptionsFragment.newInstance(cardId), "subscriptions")
    }

    override fun openSubscriptionDetail(cardId: Long, subscriptionId: Long) {
        addBackStack(SubscriptionDetailFragment.newInstance(cardId, subscriptionId), "subscriptions")
    }
}
