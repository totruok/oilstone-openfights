package ru.open.oilstone.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelProp.Option.GenerateStringOverloads
import com.airbnb.epoxy.ModelView
import kotlinx.android.synthetic.main.view_card.view.*
import ru.open.oilstone.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class CardView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        orientation = VERTICAL
        inflate(getContext(), R.layout.view_card, this)
    }

    @ModelProp(GenerateStringOverloads)
    fun setName(text: CharSequence) {
        name.text = text
    }

    @ModelProp(GenerateStringOverloads)
    fun setBalance(text: CharSequence) {
        balance.text = text
    }
}