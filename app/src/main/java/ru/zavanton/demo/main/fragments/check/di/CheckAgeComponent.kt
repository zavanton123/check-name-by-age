package ru.zavanton.demo.main.fragments.check.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.zavanton.demo.app.di.FragmentScope
import ru.zavanton.demo.main.di.MainActivityComponent
import ru.zavanton.demo.main.fragments.check.business.CheckAgeInteractor
import ru.zavanton.demo.main.fragments.check.business.ICheckAgeInteractor
import ru.zavanton.demo.main.fragments.check.ui.CheckAgeFragment
import ru.zavanton.demo.main.fragments.check.ui.CheckAgeViewModelFactory

@FragmentScope
@Component(
    dependencies = [
        MainActivityComponent::class
    ],
    modules = [
        InteractorModule::class
    ]
)
interface CheckAgeComponent {

    fun viewModelFactory(): CheckAgeViewModelFactory

    fun inject(fragment: CheckAgeFragment)
}

@Module
interface InteractorModule {

    @FragmentScope
    @Binds
    fun bindInteractor(impl: CheckAgeInteractor): ICheckAgeInteractor
}