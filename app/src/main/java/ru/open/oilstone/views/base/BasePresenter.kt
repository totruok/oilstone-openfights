package ru.open.oilstone.views.base

import java.lang.ref.WeakReference

abstract class BasePresenter<View : BaseView> {

    var viewReference: WeakReference<View>? = null

    val view get() = viewReference?.get()

    fun bind(view: View) {
        if (view != this.view) {
            viewReference = WeakReference(view)
        }
    }

    fun unbind(view: BaseView) {
        viewReference = null
    }
}
