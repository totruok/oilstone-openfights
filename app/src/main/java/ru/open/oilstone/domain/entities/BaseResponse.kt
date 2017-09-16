package ru.open.oilstone.domain.entities


data class BaseResponse(
        val errorCode: Int = 0,
        val errorDescription: String = "")