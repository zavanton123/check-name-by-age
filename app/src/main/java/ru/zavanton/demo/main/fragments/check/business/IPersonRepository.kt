package ru.zavanton.demo.main.fragments.check.business

import ru.zavanton.demo.main.fragments.check.business.model.PersonCheckDomainModel

interface IPersonRepository {

    suspend fun fetchPerson(name: String): PersonCheckDomainModel
}
