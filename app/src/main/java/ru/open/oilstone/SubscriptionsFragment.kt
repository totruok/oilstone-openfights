package ru.open.oilstone

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import editor.video.motion.fast.slow.core.annotations.Back
import editor.video.motion.fast.slow.core.annotations.Title
import kotlinx.android.synthetic.main.fragment_card.*
import ru.open.oilstone.base.BaseFragment
import ru.open.oilstone.controllers.SubscriptionsController
import ru.open.oilstone.entities.Subscription
import ru.open.oilstone.models.OpenViewModelFactory
import ru.open.oilstone.models.SubscriptionsViewModel
import javax.inject.Inject

@Back
@Title(R.string.title_subscriptions)
class SubscriptionsFragment : BaseFragment(), SubscriptionsController.AdapterCallbacks {

    private val TAG = this.javaClass.simpleName!!

    @Inject
    lateinit var viewModelFactory: OpenViewModelFactory

    private val recycledViewPool = RecyclerView.RecycledViewPool()
    private val controller = SubscriptionsController(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_subscriptions, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)

        recyclerView.recycledViewPool = recycledViewPool
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
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