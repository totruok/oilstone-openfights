package ru.open.oilstone

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import android.view.View
import editor.video.motion.fast.slow.core.annotations.Back
import editor.video.motion.fast.slow.core.annotations.Title
import kotlinx.android.synthetic.main.layout_recycler.*
import ru.open.oilstone.controllers.SubscriptionsController
import ru.open.oilstone.entities.Subscription
import ru.open.oilstone.models.OpenViewModelFactory
import ru.open.oilstone.models.SubscriptionsViewModel
import javax.inject.Inject

@Back
@Title(R.string.title_subscriptions)
class SubscriptionsFragment : RecyclerFragment(), SubscriptionsController.AdapterCallbacks {

    private val TAG = this.javaClass.simpleName!!

    @Inject
    lateinit var viewModelFactory: OpenViewModelFactory
    private val controller = SubscriptionsController(this)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        controller.context = context.applicationContext
        recyclerView.adapter = controller.adapter

        SubscriptionsViewModel.create(this, viewModelFactory).subscriptions.observe(this, Observer {
            Log.d(TAG, it.toString())
            controller.setData(it)
        })
    }

    override fun onSubscriptionClicked(subscription: Subscription) {
        Log.d(TAG, subscription.name)
    }
}