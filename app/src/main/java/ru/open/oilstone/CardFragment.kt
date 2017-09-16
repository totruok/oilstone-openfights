package ru.open.oilstone

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView.RecycledViewPool
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_card.*
import ru.open.oilstone.base.BaseFragment
import ru.open.oilstone.controllers.CardController
import ru.open.oilstone.models.CardBlockViewModel
import ru.open.oilstone.models.OpenViewModelFactory
import javax.inject.Inject


class CardFragment : BaseFragment(), CardController.AdapterCallbacks {

    @Inject
    lateinit var viewModelFactory: OpenViewModelFactory

    private val recycledViewPool = RecycledViewPool()
    private val controller = CardController(this, recycledViewPool)

    private val TAG = this.javaClass.simpleName!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)

        recyclerView.recycledViewPool = recycledViewPool
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true);
        recyclerView.adapter = controller.adapter

        CardBlockViewModel.create(this, viewModelFactory).card.observe(this, Observer {
            controller.setData(it)
        })
    }

    override fun onDepositClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPurchasedClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSubscriptionsClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
