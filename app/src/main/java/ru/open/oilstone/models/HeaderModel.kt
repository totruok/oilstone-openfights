package ru.open.oilstone.models

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import ru.open.oilstone.R

abstract class HeaderModel : EpoxyModelWithHolder<HeaderModel.InvoiceHolder>() {

    class InvoiceHolder: EpoxyHolder() {
        lateinit var title: TextView
        lateinit var nameCard: TextView
        lateinit var summary: TextView

        override fun bindView(itemView: View) {
            title = itemView.findViewById(R.id.title)
            nameCard = itemView.findViewById(R.id.description)
            summary = itemView.findViewById(R.id.summary)
        }
    }
}