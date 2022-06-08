package ru.zavanton.demo.main.di

import dagger.Component
import retrofit2.Retrofit
import ru.zavanton.demo.app.di.ActivityScope
import ru.zavanton.demo.app.di.AppComponent
import ru.zavanton.demo.main.MainActivity


@ActivityScope
@Component(
    dependencies = [
        AppComponent::class
    ]
)
interface MainActivityComponent {

    fun provideRetrofit(): Retrofit

    fun inject(activity: MainActivity)
}
