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

@EpoxyModelClass(layout = R.layout.view_recomend)
abstract class RecomendModelHolder : EpoxyModelWithHolder<RecomendModelHolder.RecomendHolder>() {
    @EpoxyAttribute
    var logo: String = ""
    @EpoxyAttribute
    var description: String = ""
    @EpoxyAttribute
    var name: String = ""
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null

    override fun bind(holder: RecomendHolder) {
        super.bind(holder)

        Picasso.with(holder.logo.context)
                .load(logo)
                .resizeDimen(R.dimen.avatar_size, R.dimen.avatar_size)
                .centerCrop()
                .into(holder.logo)
        holder.description.text = description
        holder.name.text = name
        holder.itemView.setOnClickListener(clickListener)
    }

    override fun unbind(holder: RecomendHolder) {
        super.unbind(holder)
        holder.itemView.setOnClickListener(null)
    }

    class RecomendHolder : EpoxyHolder() {
        lateinit var itemView: View
        lateinit var logo: ImageView
        lateinit var name: TextView
        lateinit var description: TextView

        override fun bindView(itemView: View) {
            this.itemView = itemView
            logo = itemView.findViewById(R.id.logo)
            name = itemView.findViewById(R.id.name)
            description = itemView.findViewById(R.id.description)
        }
    }
}