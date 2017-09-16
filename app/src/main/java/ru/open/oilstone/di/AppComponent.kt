package ru.open.oilstone.di

import dagger.Component
import ru.open.oilstone.App
import ru.open.oilstone.views.CardFragment
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ApiModule::class))
interface AppComponent {

    fun inject(application: App)

    fun inject(cardFragment: CardFragment)

}
