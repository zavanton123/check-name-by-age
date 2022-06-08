package ru.zavanton.demo.app

import android.app.Application
import ru.zavanton.demo.app.di.AppComponentManager

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponentManager.init(this)
    }
}
