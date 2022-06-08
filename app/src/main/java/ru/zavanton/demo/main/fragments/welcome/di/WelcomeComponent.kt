package ru.zavanton.demo.main.fragments.welcome.di

import dagger.Component
import ru.zavanton.demo.app.di.FragmentScope
import ru.zavanton.demo.main.di.MainActivityComponent
import ru.zavanton.demo.main.fragments.welcome.ui.WelcomeFragment

@FragmentScope
@Component(
    dependencies = [
        MainActivityComponent::class
    ]
)
interface WelcomeComponent {

    fun inject(fragment: WelcomeFragment)
}
