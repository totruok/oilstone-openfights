package ru.open.oilstone.models

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import ru.open.oilstone.data.OpenRepository
import javax.inject.Inject


class OpenViewModelFactory @Inject constructor(private val openRepository: OpenRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardBlockViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CardBlockViewModel(openRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
