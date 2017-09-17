package ru.open.oilstone.holders

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import ru.open.oilstone.R


@EpoxyModelClass(layout = R.layout.view_button)
abstract class ButtonModelHolder : EpoxyModelWithHolder<ButtonModelHolder.ButtonHolder>() {
    @EpoxyAttribute
    var textRes: Int = 0
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null

    override fun bind(holder: ButtonHolder) {
        super.bind(holder)
        holder.button.text = holder.button.context.getString(textRes)
        holder.button.setOnClickListener(clickListener)
    }

    override fun unbind(holder: ButtonHolder) {
        super.unbind(holder)
        holder.button.setOnClickListener(null)
        holder.button.text = ""
    }

    class ButtonHolder: EpoxyHolder() {
        lateinit var button: TextView

        override fun bindView(itemView: View) {
            button = itemView as TextView
        }

    }
}