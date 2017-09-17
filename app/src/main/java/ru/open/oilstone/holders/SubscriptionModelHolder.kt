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
    }

    class SubscriptionHolder : EpoxyHolder() {
        lateinit var avatar: ImageView
        lateinit var name: TextView
        lateinit var date: TextView
        lateinit var description: TextView
        lateinit var summary: TextView

        override fun bindView(itemView: View) {
            avatar = itemView.findViewById(R.id.avatar)
            name = itemView.findViewById(R.id.name)
            date = itemView.findViewById(R.id.date)
            description = itemView.findViewById(R.id.description)
            summary = itemView.findViewById(R.id.summary)
        }
    }
}