package ru.open.oilstone.views

import android.os.Bundle
import ru.open.oilstone.R
import ru.open.oilstone.views.base.BaseActivity

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
        replace(SubscriptionsFragment())
    }

    override fun openSubscriptionDetail(id: String) {
    }
}
