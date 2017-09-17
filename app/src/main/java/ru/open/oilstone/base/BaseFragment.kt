package ru.open.oilstone.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.View
import editor.video.motion.fast.slow.core.annotations.Back
import editor.video.motion.fast.slow.core.annotations.Title
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.open.oilstone.R

open class BaseFragment : Fragment() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as BaseActivity).resolveToolbar(this)
    }

    fun getToolbar(): Toolbar? {
        return view?.findViewById(R.id.toolbar)
    }

    fun subscribe(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    open fun getTitle(): String? {
        val titleAnnotation = javaClass.annotations.find { it.annotationClass == Title::class } as? Title ?:
                throw IllegalStateException("Please override getTitle() or set @Title annotation to Fragment")
        return getString(titleAnnotation.title)
    }

    fun isBack(): Boolean {
        return javaClass.isAnnotationPresent(Back::class.java)
    }
}