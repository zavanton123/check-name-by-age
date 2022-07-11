package ru.zavanton.demo.main.fragments.check.data.repository

import ru.zavanton.demo.main.data.IStorageService
import ru.zavanton.demo.main.fragments.check.business.IPersonRepository
import ru.zavanton.demo.main.fragments.check.business.model.PersonCheckDomainModel
import ru.zavanton.demo.main.fragments.check.data.service.IPersonService
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val personService: IPersonService,
    private val storageService: IStorageService,
) : IPersonRepository {

    override suspend fun fetchPerson(name: String): PersonCheckDomainModel {
        val person = personService.fetchPersonByName(name)
        storageService.saveLatestQuery(person)
        return person
    }
}
