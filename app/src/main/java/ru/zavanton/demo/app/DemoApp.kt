package ru.zavanton.demo.app

import android.app.Application
import ru.zavanton.demo.app.di.AppComponent
import ru.zavanton.demo.app.di.DaggerAppComponent

class DemoApp : Application() {

    companion object {

        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .build()
    }
}
