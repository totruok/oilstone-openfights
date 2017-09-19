package ru.open.oilstone

import android.arch.lifecycle.Observer
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import editor.video.motion.fast.slow.core.annotations.Back
import editor.video.motion.fast.slow.core.annotations.Title
import kotlinx.android.synthetic.main.layout_recycler.*
import ru.open.oilstone.controllers.SubscriptionController
import ru.open.oilstone.entities.Comment
import ru.open.oilstone.entities.Subscription
import ru.open.oilstone.models.OpenViewModelFactory
import ru.open.oilstone.models.SubscriptionViewModel
import javax.inject.Inject


@Back
@Title(R.string.title_subscription)
class SubscriptionDetailFragment : RecyclerFragment(), SubscriptionController.AdapterCallbacks {

    @Inject
    lateinit var viewModelFactory: OpenViewModelFactory
    private val TAG = this.javaClass.simpleName!!

    private val controller = SubscriptionController(this)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        controller.context = context.applicationContext
        recyclerView.adapter = controller.adapter
        Log.e(TAG, "subscription")

        val data = SubscriptionViewModel.create(this, viewModelFactory)

        data.setIds(getCardId(), getSubscriptionId())
        Log.e(TAG, "subscription")
        data.subscription?.observe(this, Observer {
            Log.d(TAG, it.toString())
            controller.setData(it)
        })
    }

    override fun onToggleActive(subscriptions: Subscription, active: Boolean) {
        //val data = SubscriptionViewModel.create(this, viewModelFactory)
        subscriptions.active = active
        controller.setData(subscriptions)

//        data.setIds(getCardId(), getSubscriptionId())
//        data.setUpdate(active, subscriptions.maxCost, null)
//                .observe(this, Observer {
//                    Log.d(TAG, it.toString())
//                    controller.setData(it)
//                })
    }

    override fun onClickUrl(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse(url))
        startActivity(browserIntent)
    }

    override fun onSendMessage(subscriptions: Subscription, message: String) {
        //val data = SubscriptionViewModel.create(this, viewModelFactory)
        subscriptions.comments.add(Comment(message, "Alexey"))
        controller.setData(subscriptions)
//        data.setIds(getCardId(), getSubscriptionId())
//        data.setUpdate(subscriptions.active, subscriptions.maxCost, Comment(message, "Никита"))
//                .observe(this, Observer {
//                    Log.d(TAG, it.toString())
//                    controller.setData(it)
//                })
    }

    override fun onChangeLimit(subscriptions: Subscription, maxPrice: Double) {
        //val data = SubscriptionViewModel.create(this, viewModelFactory)


//        data.setIds(getCardId(), getSubscriptionId())
//        data.setUpdate(subscriptions.active, maxPrice, null)
//                .observe(this, Observer {
//                    Log.d(TAG, it.toString())
//                    controller.setData(it)
//                })
    }

    fun getCardId(): Long = arguments.getLong(SubscriptionsFragment.KEY_CARD_ID)
    fun getSubscriptionId(): Long = arguments.getLong(KEY_SUBSCRIPTION)

    companion object {
        val KEY_CARD_ID = "card_id"
        val KEY_SUBSCRIPTION = "subscription_id"

        fun newInstance(cardId: Long, subscriptionId: Long): Fragment {
            val fragment = SubscriptionDetailFragment()
            val bundle = Bundle()
            bundle.putLong(KEY_CARD_ID, cardId)
            bundle.putLong(KEY_SUBSCRIPTION, subscriptionId)
            fragment.arguments = bundle
            return fragment
        }
    }
}