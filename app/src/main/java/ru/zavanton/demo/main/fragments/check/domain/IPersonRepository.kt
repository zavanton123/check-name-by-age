package ru.zavanton.demo.main.fragments.check.domain

import ru.zavanton.demo.main.fragments.check.domain.model.PersonCheckDomainModel

interface IPersonRepository {

    suspend fun fetchPerson(name: String): PersonCheckDomainModel
}
