package ru.zavanton.demo.main.fragments.welcome.domain

import ru.zavanton.demo.main.fragments.welcome.domain.model.PersonWelcomeDomainModel

interface IWelcomeInteractor {

    suspend fun fetchLatestName(): PersonWelcomeDomainModel
}
