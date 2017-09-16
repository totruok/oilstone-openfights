package ru.open.oilstone

import android.app.Application
import com.facebook.stetho.Stetho
import ru.open.oilstone.di.*

class App : Application() {
    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initStetho()
        initComponent()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun initComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .apiModule(ApiModule())
                .build()
    }

}