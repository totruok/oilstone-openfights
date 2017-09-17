package ru.open.oilstone.holders

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import ru.open.oilstone.R

@EpoxyModelClass(layout = R.layout.view_title)
abstract class TitleModelHolder : EpoxyModelWithHolder<TitleModelHolder.TitleHolder>() {
    @EpoxyAttribute
    var textRes: Int = 0

    override fun bind(holder: TitleHolder) {
        super.bind(holder)
        holder.title.text = holder.title.context.getString(textRes)
    }

    override fun unbind(holder: TitleHolder) {
        super.unbind(holder)
        holder.title.text = ""
    }

    class TitleHolder : EpoxyHolder() {
        lateinit var title: TextView

        override fun bindView(itemView: View) {
            title = itemView.findViewById(R.id.title)
        }

    }
}