package ru.open.oilstone


interface MainRouter {
    fun openCard()
    fun openSubscriptions(cardId: Long) {}
    fun openSubscriptionDetail(cardId: Long, subscriptionId: Long)
}
