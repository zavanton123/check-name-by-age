package ru.zavanton.demo.main.di

import dagger.Binds
import dagger.Component
import dagger.Module
import retrofit2.Retrofit
import ru.zavanton.demo.app.di.ActivityScope
import ru.zavanton.demo.app.di.AppComponent
import ru.zavanton.demo.main.MainActivity
import ru.zavanton.demo.main.business.IStorageService
import ru.zavanton.demo.main.business.StorageService


@ActivityScope
@Component(
    dependencies = [
        AppComponent::class,
    ],
    modules = [
        StorageServiceModule::class,
    ],
)
interface MainActivityComponent {

    fun provideRetrofit(): Retrofit

    fun provideStorageService(): IStorageService

    fun inject(activity: MainActivity)
}

@Module
interface StorageServiceModule {

    @ActivityScope
    @Binds
    fun bindsStorageService(impl: StorageService): IStorageService
}
