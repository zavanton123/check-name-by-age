package ru.zavanton.demo.main.fragments.welcome.domain

import ru.zavanton.demo.main.fragments.welcome.data.repository.WelcomeRepository
import ru.zavanton.demo.main.fragments.welcome.domain.model.PersonWelcomeDomainModel
import javax.inject.Inject

class WelcomeInteractor @Inject constructor(
    private val welcomeRepository: WelcomeRepository,
) : IWelcomeInteractor {

    override suspend fun fetchLatestName(): PersonWelcomeDomainModel {
        return welcomeRepository.fetchPerson()
    }
}
