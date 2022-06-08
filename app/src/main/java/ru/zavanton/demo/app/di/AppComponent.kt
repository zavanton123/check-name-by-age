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
        fun addContext(context: Context): Builder

        fun build(): AppComponent
    }

    fun provideRetrofit(): Retrofit

    fun provideSharedPrefs(): SharedPreferences
}

@Module
class NetworkingModule {

    companion object {
        const val BASE_URL = "https://api.agify.io/"
    }

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
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .build()
    }
}

@Module
class SharedPreferencesModule {

    companion object {
        private const val PREFS_FILE_NAME = "prefs"
    }

    @AppScope
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
    }
}
