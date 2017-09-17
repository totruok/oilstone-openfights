package ru.open.oilstone.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.squareup.picasso.Picasso
import ru.open.oilstone.R

@EpoxyModelClass(layout = R.layout.view_subscription)
abstract class SubscriptionModelHolder : EpoxyModelWithHolder<SubscriptionModelHolder.SubscriptionHolder>() {
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
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null
    @EpoxyAttribute
    var canceled: Boolean = false

    override fun bind(holder: SubscriptionHolder) {
        super.bind(holder)

        Picasso.with(holder.avatar.context)
                .load(avatar)
                .resizeDimen(R.dimen.avatar_size, R.dimen.avatar_size)
                .centerCrop()
                .into(holder.avatar)
        holder.name.text = name
        holder.date.text = date
        holder.description.text = description
        holder.summary.text = summary

        holder.itemView.setOnClickListener(clickListener)
        if (canceled) {
            holder.status.visibility = View.VISIBLE
            holder.status.text = holder.status.context.getString(R.string.canceled_subscription)
        } else {
            holder.status.visibility = View.GONE
            holder.status.text = ""
        }
    }

    override fun unbind(holder: SubscriptionHolder) {
        super.unbind(holder)
        holder.itemView.setOnClickListener(null)
    }

    class SubscriptionHolder : EpoxyHolder() {
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