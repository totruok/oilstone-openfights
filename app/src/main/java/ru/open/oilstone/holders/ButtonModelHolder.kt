package ru.open.oilstone.holders

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import ru.open.oilstone.R

abstract class ButtonModelHolder : EpoxyModelWithHolder<ButtonModelHolder.ButtonHolder>() {

    class ButtonHolder: EpoxyHolder() {
        lateinit var text: TextView

        override fun bindView(itemView: View) {
            text = itemView.findViewById(R.id.text)
        }
    }
}