package ru.open.oilstone.holders

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import ru.open.oilstone.R

@EpoxyModelClass(layout = R.layout.view_card)
abstract class CardModelHolder : EpoxyModelWithHolder<CardModelHolder.CardHolder>() {
    @EpoxyAttribute
    var name: String = ""
    @EpoxyAttribute
    var balance: String = ""

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var depositClickListener: View.OnClickListener? = null
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var purchaseClickListener: View.OnClickListener? = null

    override fun bind(holder: CardHolder) {
        super.bind(holder)
        holder.name.text = name
        holder.balance.text = balance
        holder.deposit.setOnClickListener(depositClickListener)
        holder.purchase.setOnClickListener(purchaseClickListener)
    }

    class CardHolder : EpoxyHolder() {
        lateinit var name: TextView
        lateinit var balance: TextView
        lateinit var deposit: View
        lateinit var purchase: View

        override fun bindView(itemView: View) {
            name = itemView.findViewById(R.id.name)
            balance = itemView.findViewById(R.id.balance)
            deposit = itemView.findViewById(R.id.deposit)
            purchase = itemView.findViewById(R.id.purchase)
        }
    }
}