package ru.open.oilstone.di

import dagger.Module
import dagger.Provides
import ru.open.oilstone.data.OpenApi
import ru.open.oilstone.data.OpenRepository
import ru.open.oilstone.data.OpenRepositoryImpl
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideOpenRepository(api: OpenApi): OpenRepository {
        return OpenRepositoryImpl(api)

    }
}
