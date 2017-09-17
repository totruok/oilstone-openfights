package ru.open.oilstone

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_recycler.*
import ru.open.oilstone.base.BaseFragment
import ru.open.oilstone.controllers.SubscriptionsController
import ru.open.oilstone.entities.Subscription

open class RecyclerFragment : BaseFragment(), SubscriptionsController.AdapterCallbacks {

    private val TAG = this.javaClass.simpleName!!

    private val recycledViewPool = RecyclerView.RecycledViewPool()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.recycledViewPool = recycledViewPool
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
    }

    override fun onSubscriptionClicked(subscription: Subscription) {
        Log.d(TAG, subscription.name)
    }
}