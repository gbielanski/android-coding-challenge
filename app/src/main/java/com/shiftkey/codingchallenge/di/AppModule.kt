package com.shiftkey.codingchallenge.di

import com.shiftkey.codingchallenge.data.ShiftsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(ActivityRetainedComponent::class)
@Module
internal class AppModule {
    @Provides
    fun okhttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_VALUE_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_VALUE_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_VALUE_SECONDS, TimeUnit.SECONDS)
            .callTimeout(TIMEOUT_VALUE_SECONDS, TimeUnit.SECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://staging-app.shiftkey.com/api/v2/")
            .build()
    }

    @Provides
    fun orderApi(retrofit: Retrofit): ShiftsApi {
        return retrofit.create(ShiftsApi::class.java)
    }

    @Provides
    fun ioDispatcher() = Dispatchers.IO
}

private const val TIMEOUT_VALUE_SECONDS = 10L