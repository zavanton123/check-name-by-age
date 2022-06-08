package ru.zavanton.demo.app.di

import android.content.Context

object AppComponentManager {
    private lateinit var appComponent: AppComponent

    fun init(context: Context) {
        appComponent = DaggerAppComponent.builder()
            .addContext(context)
            .build()
    }

    fun getAppComponent(): AppComponent {
        if (!this::appComponent.isInitialized) {
            throw RuntimeException("AppComponent must be initialized first!")
        }
        return appComponent
    }
}
