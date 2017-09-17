package ru.open.oilstone.holders

import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.squareup.picasso.Picasso
import ru.open.oilstone.R

@EpoxyModelClass(layout = R.layout.view_invoice)
abstract class InvoiceModelHolder : EpoxyModelWithHolder<InvoiceModelHolder.InvoiceHolder>() {
    @EpoxyAttribute
    var avatar: String = ""
    @EpoxyAttribute
    var date: String = ""
    @EpoxyAttribute
    var description: String = ""
    @EpoxyAttribute
    var summary: String = ""
    @EpoxyAttribute
    var name: String = ""
    @EpoxyAttribute
    var bgResColor: Int = 0
    @EpoxyAttribute
    var timeColor: Int = 0
    @EpoxyAttribute
    var otherTextColor: Int = 0
    @EpoxyAttribute
    var canceled: Boolean = false
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null

    override fun bind(holder: InvoiceHolder) {
        super.bind(holder)

        Picasso.with(holder.avatar.context)
                .load(avatar)
                .resizeDimen(R.dimen.avatar_size, R.dimen.avatar_size)
                .centerCrop()
                .into(holder.avatar)
        holder.date.text = date
        holder.date.setTextColor(ContextCompat.getColor(holder.date.context, timeColor))
        holder.description.text = description
        holder.description.setTextColor(ContextCompat.getColor(holder.description.context, otherTextColor))
        holder.summary.text = summary
        holder.summary.setTextColor(ContextCompat.getColor(holder.summary.context, otherTextColor))
        holder.name.text = name
        holder.name.setTextColor(ContextCompat.getColor(holder.name.context, otherTextColor))
        holder.itemView.setBackgroundResource(bgResColor)

        if (canceled) {
            holder.status.visibility = View.VISIBLE
            holder.status.text = holder.status.context.getString(R.string.canceled_transaction)
        } else {
            holder.status.visibility = View.GONE
            holder.status.text = ""
        }
        holder.status.setTextColor(ContextCompat.getColor(holder.status.context, timeColor))
        holder.itemView.setOnClickListener(clickListener)
    }

    override fun unbind(holder: InvoiceHolder) {
        super.unbind(holder)
        holder.itemView.setOnClickListener(null)
    }

    class InvoiceHolder: EpoxyHolder() {
        lateinit var itemView: View
        lateinit var avatar: ImageView
        lateinit var name: TextView
        lateinit var date: TextView
        lateinit var description: TextView
        lateinit var summary: TextView
        lateinit var status: TextView

        override fun bindView(itemView: View) {
            this.itemView = itemView
            avatar = itemView.findViewById(R.id.avatar)
            name = itemView.findViewById(R.id.name)
            date = itemView.findViewById(R.id.date)
            description = itemView.findViewById(R.id.description)
            summary = itemView.findViewById(R.id.summary)
            status = itemView.findViewById(R.id.status)
        }
    }
}

