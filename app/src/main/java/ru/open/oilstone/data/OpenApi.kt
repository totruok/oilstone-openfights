package ru.open.oilstone.data

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import ru.open.oilstone.entities.*

interface OpenApi {

    @GET("/MyCards/1.0.0/list")
    fun cards(): Single<CardsResponse>

    @POST("/MyCards/1.0.0/MyCards/balance")
    fun balance(@Body body: Map<String, Long>): Single<BalanceResponse>

    @POST("/MyCards/1.0.0/MyCardsInfo/history")
    fun history(@Body body: Map<String, Long>): Single<TransactionResponse>

    @POST("/MySubscribtions/1.0.0/list")
    fun subscriptions(@Body body: Map<String, Long>): Single<SubscriptionsResponse>

    @POST("/MySubscribtions/1.0.0/getById")
    fun subscription(@Body body: Map<String, String>): Single<SubscriptionResponse>

    @FormUrlEncoded
    @POST("MySubscribtions/1.0.0/getById")
    fun subscriptionSetSettings(@Body body: Map<String, String>): Single<SubscriptionResponse>
}
