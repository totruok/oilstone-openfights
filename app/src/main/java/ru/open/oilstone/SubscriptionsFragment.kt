package ru.open.oilstone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import editor.video.motion.fast.slow.core.annotations.Back
import editor.video.motion.fast.slow.core.annotations.Title
import ru.open.oilstone.base.BaseFragment
import ru.open.oilstone.controllers.SubscriptionsController
import ru.open.oilstone.entities.Subscription

@Back
@Title(R.string.title_subscriptions)
class SubscriptionsFragment : BaseFragment(), SubscriptionsController.AdapterCallbacks {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_subscriptions, container, false)
    }

    override fun onSubscriptionClicked(subscription: Subscription) {

    }
}