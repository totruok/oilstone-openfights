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

    override fun openSubscriptions() {
        addBackStack(SubscriptionsFragment(), "subscriptions")
    }

    override fun openSubscriptionDetail(id: String) {
    }
}
