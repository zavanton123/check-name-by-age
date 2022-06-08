package ru.zavanton.demo.main.di

import ru.zavanton.demo.app.DemoApp

object ActivityComponentManager {
    private var appComponent: MainActivityComponent? = null

    fun getAppComponent(): MainActivityComponent =
        appComponent ?: DaggerMainActivityComponent.builder()
            .appComponent(DemoApp.appComponent)
            .build()
            .also {
                appComponent = it
            }

    fun clearAppComponent() {
        appComponent = null
    }
}
