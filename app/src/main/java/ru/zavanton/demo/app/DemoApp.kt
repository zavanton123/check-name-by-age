package ru.zavanton.demo.app

import android.app.Application
import android.util.Log

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("zavanton", "zavanton - app onCreate")
    }
}
