package ru.open.oilstone.models

import android.arch.lifecycle.ViewModel
import ru.open.oilstone.data.OpenRepository
import javax.inject.Inject

class SubscriptionsViewModel @Inject constructor(private val repository: OpenRepository) : ViewModel()