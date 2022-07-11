package ru.zavanton.demo.main.fragments.welcome.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.zavanton.demo.app.di.FragmentScope
import ru.zavanton.demo.main.di.MainActivityComponent
import ru.zavanton.demo.main.fragments.welcome.data.repository.WelcomeRepository
import ru.zavanton.demo.main.fragments.welcome.domain.IWelcomeInteractor
import ru.zavanton.demo.main.fragments.welcome.domain.IWelcomeRepository
import ru.zavanton.demo.main.fragments.welcome.domain.WelcomeInteractor
import ru.zavanton.demo.main.fragments.welcome.ui.WelcomeFragment

@FragmentScope
@Component(
    dependencies = [
        MainActivityComponent::class
    ],
    modules = [
        WelcomeModule::class,
    ]
)
interface WelcomeComponent {

    fun inject(fragment: WelcomeFragment)
}

@Module
interface WelcomeModule {

    @FragmentScope
    @Binds
    fun bindInteractor(impl: WelcomeInteractor): IWelcomeInteractor

    @FragmentScope
    @Binds
    fun bindRepository(impl: WelcomeRepository): IWelcomeRepository
}
