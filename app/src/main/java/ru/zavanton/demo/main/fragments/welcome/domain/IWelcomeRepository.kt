package ru.zavanton.demo.main.fragments.welcome.domain

import ru.zavanton.demo.main.fragments.welcome.domain.model.PersonWelcomeDomainModel

interface IWelcomeRepository {

    suspend fun fetchPerson(): PersonWelcomeDomainModel
}