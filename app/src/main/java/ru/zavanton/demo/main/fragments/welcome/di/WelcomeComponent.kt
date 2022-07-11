package ru.zavanton.demo.main.fragments.welcome.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.zavanton.demo.app.di.FragmentScope
import ru.zavanton.demo.main.di.MainActivityComponent
import ru.zavanton.demo.main.fragments.welcome.business.IWelcomeInteractor
import ru.zavanton.demo.main.fragments.welcome.business.WelcomeInteractor
import ru.zavanton.demo.main.fragments.welcome.ui.WelcomeFragment

@FragmentScope
@Component(
    dependencies = [
        MainActivityComponent::class
    ],
    modules = [
        InteractorModule::class,
    ]
)
interface WelcomeComponent {

    fun inject(fragment: WelcomeFragment)
}

@Module
interface InteractorModule {

    @FragmentScope
    @Binds
    fun bindInteractor(impl: WelcomeInteractor): IWelcomeInteractor
}
