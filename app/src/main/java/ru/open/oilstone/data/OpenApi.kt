package ru.open.oilstone.data

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import ru.open.oilstone.entities.*

interface OpenApi {

    @GET("/MyCards/1.0.0/MyCardsInfo/cardlist")
    fun cards(): Single<CardsResponse>

    @POST("/MyCards/1.0.0/MyCardsInfo/balance")
    fun balance(@Body body: Map<String, Int>): Single<BalanceResponse>

    @POST("/MyCards/1.0.0/MyCardsInfo/history")
    fun history(@Body body: Map<String, Int>): Single<TransactionResponse>

    @GET("/MyCards/1.0.0/MySubscription/list")
    fun subscriptions(): Single<SubscriptionsResponse>

    @GET("/MyCards/1.0.0/MySubscription/details")
    fun subscriptionDetail(): Single<SubscriptionDetailResponse>

    @FormUrlEncoded
    @POST("/MyCards/1.0.0/MySubscription/set")
    fun subscriptionSetSettings(): Single<SubscriptionSettingsResponse>
}
