package ru.zavanton.demo.main.di

import ru.zavanton.demo.app.di.AppComponentManager

object ActivityComponentManager {

    private var activityComponent: MainActivityComponent? = null

    fun getAppComponent(): MainActivityComponent =
        activityComponent ?: DaggerMainActivityComponent.builder()
            .appComponent(AppComponentManager.getAppComponent())
            .build()
            .also {
                activityComponent = it
            }

    fun clear() {
        activityComponent = null
    }
}
