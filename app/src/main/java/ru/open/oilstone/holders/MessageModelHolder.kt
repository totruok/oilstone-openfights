package ru.open.oilstone.holders

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import ru.open.oilstone.R

@EpoxyModelClass(layout = R.layout.view_message)
abstract class MessageModelHolder : EpoxyModelWithHolder<MessageModelHolder.InvoiceHolder>() {
    @EpoxyAttribute
    var name: String = ""
    @EpoxyAttribute
    var text: String = ""

    override fun bind(holder: InvoiceHolder) {
        super.bind(holder)

        holder.name.text = name
        holder.text.text = text
    }

    override fun unbind(holder: InvoiceHolder) {
        super.unbind(holder)
        holder.itemView.setOnClickListener(null)
    }

    class InvoiceHolder : EpoxyHolder() {
        lateinit var itemView: View
        lateinit var name: TextView
        lateinit var text: TextView


        override fun bindView(itemView: View) {
            this.itemView = itemView
            name = itemView.findViewById(R.id.name)
            text = itemView.findViewById(R.id.text)
        }
    }
}