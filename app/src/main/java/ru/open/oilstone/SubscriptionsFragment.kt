package ru.open.oilstone

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
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

        Log.e(TAG, "test")
        val data = SubscriptionsViewModel.create(this, viewModelFactory)

        data.setId(getCardId())
        Log.e(TAG, "subscription")
        data.subscriptions?.observe(this, Observer {
            Log.d(TAG, it.toString())
            controller.setData(it)
        })
    }

    fun getCardId(): Long = arguments.getLong(KEY_CARD_ID)

    override fun onSubscriptionClicked(subscription: Subscription) {
        Log.d(TAG, subscription.name)
        (activity as MainRouter).openSubscriptionDetail(getCardId(), subscription.id)
    }

    companion object {
        val KEY_CARD_ID = "card_id"

        fun newInstance(cardId: Long): Fragment {
            val fragment = SubscriptionsFragment()
            val bundle = Bundle()
            bundle.putLong(KEY_CARD_ID, cardId)
            fragment.arguments = bundle
            return fragment
        }
    }
}