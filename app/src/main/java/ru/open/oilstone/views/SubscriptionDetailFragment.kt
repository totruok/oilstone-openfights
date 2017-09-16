package ru.open.oilstone.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.open.oilstone.R
import ru.open.oilstone.views.base.BaseFragment

class SubscriptionDetailFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_subscription_detail, container, false)
    }
}