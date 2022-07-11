package ru.zavanton.demo.main.fragments.welcome.data.repository

import ru.zavanton.demo.app.di.FragmentScope
import ru.zavanton.demo.main.data.IStorageService
import ru.zavanton.demo.main.fragments.welcome.data.converter.WelcomeDataConverter
import ru.zavanton.demo.main.fragments.welcome.domain.IWelcomeRepository
import ru.zavanton.demo.main.fragments.welcome.domain.model.PersonWelcomeDomainModel
import javax.inject.Inject

@FragmentScope
class WelcomeRepository @Inject constructor(
    private val storageService: IStorageService,
    private val converter: WelcomeDataConverter,
) : IWelcomeRepository {

    override suspend fun fetchPerson(): PersonWelcomeDomainModel {
        val person = storageService.fetchLatestPerson()
        return converter.convertToDomain(person)
    }
}