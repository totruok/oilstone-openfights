package ru.open.oilstone.holders

import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import ru.open.oilstone.R

@EpoxyModelClass(layout = R.layout.view_controlls)
abstract class ToggleModelHolder : EpoxyModelWithHolder<ToggleModelHolder.ControlHolder>() {

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var onCheckedListener: CompoundButton.OnCheckedChangeListener? = null
    @EpoxyAttribute
    var textRes: Int = 0
    @EpoxyAttribute
    var active: Boolean = true

    override fun bind(holder: ControlHolder) {
        super.bind(holder)

        holder.switch.setOnCheckedChangeListener(null)
        holder.switch.isChecked = !active
        holder.switch.setOnCheckedChangeListener(onCheckedListener)
    }

    override fun unbind(holder: ControlHolder) {
        super.unbind(holder)
        holder.switch.setOnCheckedChangeListener(null)
    }

    class ControlHolder : EpoxyHolder() {
        lateinit var switch: Switch

        override fun bindView(itemView: View) {
            switch = itemView.findViewById(R.id.switch_toggle)
        }

    }
}