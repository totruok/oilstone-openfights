package ru.open.oilstone

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import editor.video.motion.fast.slow.core.annotations.Title
import kotlinx.android.synthetic.main.layout_recycler.*
import ru.open.oilstone.controllers.CardController
import ru.open.oilstone.models.CardBlockViewModel
import ru.open.oilstone.models.OpenViewModelFactory
import javax.inject.Inject


@Title(R.string.title_family_card)
class CardFragment : RecyclerFragment(), CardController.AdapterCallbacks {

    @Inject
    lateinit var viewModelFactory: OpenViewModelFactory

    private val controller = CardController(this)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        recyclerView.adapter = controller.adapter

        CardBlockViewModel.create(this, viewModelFactory).card.observe(this, Observer {
            controller.setData(it)
        })
    }


    override fun onDepositClicked() {

    }

    override fun onPurchasedClicked() {

    }

    override fun onSubscriptionsClicked() {
        (activity as MainRouter).openSubscriptions()
    }
}
