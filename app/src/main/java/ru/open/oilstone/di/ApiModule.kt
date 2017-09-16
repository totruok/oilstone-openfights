package ru.open.oilstone.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.open.oilstone.BuildConfig
import ru.open.oilstone.data.OpenApi
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideOpenApi(builder: Retrofit.Builder): OpenApi {
        return builder
                .baseUrl(BuildConfig.API_URL)
                .build()
                .create(OpenApi::class.java)
    }

}