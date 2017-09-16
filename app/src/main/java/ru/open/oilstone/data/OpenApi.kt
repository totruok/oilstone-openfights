package ru.open.oilstone.data

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import ru.open.oilstone.entities.Card
import ru.open.oilstone.entities.CardBalanceResponse
import ru.open.oilstone.entities.CardTransactionResponse
import ru.open.oilstone.entities.CardsResponse

interface OpenApi {

    @GET("/MyCards/1.0.0/MyCardsInfo/cardlist")
    fun cardList(): Single<CardsResponse>

    @GET("/MyCards/1.0.0/MyCardsInfo/balance")
    fun cardBalance(@Body card: Card): Single<CardBalanceResponse>

    @FormUrlEncoded
    @POST("/MyCards/1.0.0/MyCardsInfo/history")
    fun cardHistory(@Body card: Card): Single<CardTransactionResponse>
}
