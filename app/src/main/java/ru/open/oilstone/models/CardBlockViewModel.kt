package ru.open.oilstone.models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import ru.open.oilstone.CardFragment
import ru.open.oilstone.data.OpenRepository


class CardBlockViewModel constructor(private val repository: OpenRepository) : ViewModel() {

    var card: LiveData<CardBlock> = repository.getCardBlock()
        private set

    companion object {
        fun create(fragment: CardFragment, factory: ViewModelProvider.Factory): CardBlockViewModel {
            return ViewModelProviders.of(fragment, factory).get(CardBlockViewModel::class.java)
        }
    }

}
