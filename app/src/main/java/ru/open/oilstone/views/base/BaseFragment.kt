package ru.open.oilstone.views.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseFragment : Fragment() {

    private var compositeDisposable: CompositeDisposable? = null

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable?.clear()
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        compositeDisposable = CompositeDisposable()
    }

    fun subscribe(disposable: Disposable) {
        compositeDisposable?.add(disposable)
    }

}