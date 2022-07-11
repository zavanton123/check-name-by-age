package ru.zavanton.demo.main.fragments.check.di

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.zavanton.demo.app.di.FragmentScope
import ru.zavanton.demo.main.di.MainActivityComponent
import ru.zavanton.demo.main.fragments.check.business.CheckAgeInteractor
import ru.zavanton.demo.main.fragments.check.business.ICheckAgeInteractor
import ru.zavanton.demo.main.fragments.check.business.IPersonRepository
import ru.zavanton.demo.main.fragments.check.data.api.CheckAgeApi
import ru.zavanton.demo.main.fragments.check.data.repository.PersonRepository
import ru.zavanton.demo.main.fragments.check.data.service.PersonService
import ru.zavanton.demo.main.fragments.check.data.service.IPersonService
import ru.zavanton.demo.main.fragments.check.ui.CheckAgeFragment

@FragmentScope
@Component(
    dependencies = [
        MainActivityComponent::class
    ],
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        ServiceModule::class,
        ApiModule::class,
    ],
)
interface CheckAgeComponent {

    fun inject(fragment: CheckAgeFragment)
}

@Module
interface InteractorModule {
    @FragmentScope
    @Binds
    fun bindInteractor(impl: CheckAgeInteractor): ICheckAgeInteractor
}

@Module
interface RepositoryModule {
    @FragmentScope
    @Binds
    fun bindRepository(impl: PersonRepository): IPersonRepository
}

@Module
interface ServiceModule {
    @FragmentScope
    @Binds
    fun bindService(impl: PersonService): IPersonService
}

@Module
class ApiModule {
    @FragmentScope
    @Provides
    fun provideCheckAgeApi(retrofit: Retrofit): CheckAgeApi {
        return retrofit.create(CheckAgeApi::class.java)
    }
}
