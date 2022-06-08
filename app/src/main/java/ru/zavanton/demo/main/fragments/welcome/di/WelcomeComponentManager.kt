package ru.zavanton.demo.main.fragments.welcome.di

import ru.zavanton.demo.main.di.ActivityComponentManager

object WelcomeComponentManager {
    private var fragmentComponent: WelcomeComponent? = null

    fun getComponent(): WelcomeComponent =
        fragmentComponent ?: DaggerWelcomeComponent.builder()
            .mainActivityComponent(ActivityComponentManager.getAppComponent())
            .build()
            .also {
                fragmentComponent = it
            }

    fun clearComponent() {
        fragmentComponent = null
    }
}
