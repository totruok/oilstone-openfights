package ru.open.oilstone.di

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.open.oilstone.BuildConfig
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule() {

    private val MAX_CACHE_SIZE = 1024 * 1024 * 10

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val builder = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        return builder.create()
    }

    @Provides
    @Singleton
    fun provideHttpCache(context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024L
        return Cache(File(context.cacheDir, "http"), cacheSize)
    }

    @Provides
    @Singleton
    fun provideOpenHttpClient(cache: Cache): OkHttpClient {

        var builder: OkHttpClient.Builder = OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(40, TimeUnit.SECONDS)
                .addInterceptor { chain ->
                    val original = chain.request()

                    val builder = original.newBuilder()
                            .header("Accept", "application/json")

                    chain.proceed(builder.build())
                }

        if (BuildConfig.DEBUG) {
            builder = builder
                    .addNetworkInterceptor(StethoInterceptor())
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideOpenOkHttpBuilder(client: OkHttpClient, gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
    }

}