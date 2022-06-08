package ru.zavanton.demo.main.fragments.check.di

import ru.zavanton.demo.main.di.ActivityComponentManager

object CheckAgeComponentManager {
    private var fragmentComponent: CheckAgeComponent? = null

    fun getComponent(): CheckAgeComponent =
        fragmentComponent ?: DaggerCheckAgeComponent.builder()
            .mainActivityComponent(ActivityComponentManager.getAppComponent())
            .build()
            .also {
                fragmentComponent = it
            }

    fun clearComponent() {
        fragmentComponent = null
    }
}
