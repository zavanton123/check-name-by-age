package ru.zavanton.demo.app.di

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Qualifier
@Retention
@MustBeDocumented
annotation class AppContext

@Qualifier
@Retention
@MustBeDocumented
annotation class BaseUrl

@Qualifier
@Retention
@MustBeDocumented
annotation class PrefsFilename

@AppScope
@Component(
    modules = [
        NetworkingModule::class,
        SharedPreferencesModule::class,
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun addContext(@AppContext context: Context): Builder

        @BindsInstance
        fun addBaseUrl(@BaseUrl baseUrl: String): Builder

        @BindsInstance
        fun addPrefsFilename(@PrefsFilename prefsFilename: String): Builder

        fun build(): AppComponent
    }

    fun provideRetrofit(): Retrofit

    fun provideSharedPrefs(): SharedPreferences
}

@Module
class NetworkingModule {

    @AppScope
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor { message ->
            Log.d("zavanton", "zavanton - $message")
        }
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @AppScope
    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @AppScope
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        @BaseUrl baseUrl: String,
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .build()
    }
}

@Module
class SharedPreferencesModule {

    @AppScope
    @Provides
    fun provideSharedPreferences(
        @AppContext context: Context,
        @PrefsFilename prefsFilename: String,
    ): SharedPreferences {
        return context.getSharedPreferences(prefsFilename, Context.MODE_PRIVATE)
    }
}
