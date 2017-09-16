package ru.open.oilstone.views

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.open.oilstone.App
import ru.open.oilstone.R
import ru.open.oilstone.models.CardBlockViewModel
import ru.open.oilstone.models.OpenViewModelFactory
import ru.open.oilstone.views.base.BaseFragment
import javax.inject.Inject


class CardFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: OpenViewModelFactory

    private val TAG = this.javaClass.simpleName!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        Log.d(TAG, viewModelFactory.toString())
        CardBlockViewModel.create(this, viewModelFactory).card.observe(this, Observer {
            Log.d(TAG, it.toString())
        })
    }
}
