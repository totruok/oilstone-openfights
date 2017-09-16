package ru.open.oilstone.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import ru.open.oilstone.R

abstract class InvoiceModelHolder : EpoxyModelWithHolder<InvoiceModelHolder.InvoiceHolder>() {

    class InvoiceHolder: EpoxyHolder() {
        lateinit var avatar: ImageView
        lateinit var date: TextView
        lateinit var description: TextView
        lateinit var summary: TextView

        override fun bindView(itemView: View) {
            avatar = itemView.findViewById(R.id.avatar)
            date = itemView.findViewById(R.id.date)
            description = itemView.findViewById(R.id.description)
            summary = itemView.findViewById(R.id.summary)
        }
    }
}

