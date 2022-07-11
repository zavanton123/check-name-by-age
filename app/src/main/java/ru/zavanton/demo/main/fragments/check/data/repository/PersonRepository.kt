package ru.zavanton.demo.main.fragments.check.data.repository

import ru.zavanton.demo.main.business.IStorageService
import ru.zavanton.demo.main.fragments.check.business.IPersonRepository
import ru.zavanton.demo.main.fragments.check.business.model.PersonModel
import ru.zavanton.demo.main.fragments.check.data.service.IPersonService
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val personService: IPersonService,
    private val storageService: IStorageService,
) : IPersonRepository {

    override suspend fun fetchPerson(name: String): PersonModel {
        val person = personService.fetchPersonByName(name)
        storageService.saveLatestQuery(person)
        return person
    }
}
