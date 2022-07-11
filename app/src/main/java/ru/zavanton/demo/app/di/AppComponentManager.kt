package ru.zavanton.demo.app.di

import android.content.Context
import ru.zavanton.demo.BASE_URL
import ru.zavanton.demo.PREFS_FILENAME

object AppComponentManager {

    private lateinit var appComponent: AppComponent

    fun init(context: Context) {
        appComponent = DaggerAppComponent.builder()
            .addContext(context)
            .addBaseUrl(BASE_URL)
            .addPrefsFilename(PREFS_FILENAME)
            .build()
    }

    fun getAppComponent(): AppComponent {
        if (!this::appComponent.isInitialized) {
            throw RuntimeException("AppComponent must be initialized first!")
        }
        return appComponent
    }
}
