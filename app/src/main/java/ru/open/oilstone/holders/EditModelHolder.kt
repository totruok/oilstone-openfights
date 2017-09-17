package ru.open.oilstone.holders

import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import ru.open.oilstone.R

@EpoxyModelClass(layout = R.layout.view_edit)
abstract class EditModelHolder : EpoxyModelWithHolder<EditModelHolder.TitleHolder>() {

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var submitListener: AdapterCallbacks? = null
    @EpoxyAttribute
    var textRes: Int = 0

    interface AdapterCallbacks {
        fun onSumbit(text: String)
    }

    override fun bind(holder: TitleHolder) {
        super.bind(holder)
        holder.edit.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_NULL
                    && event.getAction() == KeyEvent.ACTION_DOWN) {
                submitListener?.onSumbit(holder.edit.text.toString())
            }
            true
        }
    }

    override fun unbind(holder: TitleHolder) {
        super.unbind(holder)
    }

    class TitleHolder : EpoxyHolder() {
        lateinit var edit: EditText

        override fun bindView(itemView: View) {
            edit = itemView.findViewById(R.id.edit)
        }

    }
}