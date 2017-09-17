package ru.open.oilstone.di

import android.app.Application
import dagger.Component
import ru.open.oilstone.CardFragment
import ru.open.oilstone.SubscriptionDetailFragment
import ru.open.oilstone.SubscriptionsFragment
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RepositoryModule::class, AppModule::class, NetworkModule::class, ApiModule::class))
interface AppComponent {

    fun inject(cardFragment: CardFragment)

    fun inject(subscriptionsFragment: SubscriptionsFragment)

    fun inject(subscriptionDetailFragment: SubscriptionDetailFragment)

    companion object Factory {
        fun create(app: Application) = DaggerAppComponent.builder().
                appModule(AppModule(app)).
                apiModule(ApiModule()).
                networkModule(NetworkModule()).
                repositoryModule(RepositoryModule()).
                build()
    }
}
