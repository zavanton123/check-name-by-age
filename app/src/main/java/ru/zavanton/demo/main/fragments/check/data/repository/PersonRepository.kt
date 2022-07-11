package ru.zavanton.demo.main.fragments.check.data.repository

import ru.zavanton.demo.main.data.IStorageService
import ru.zavanton.demo.main.fragments.check.domain.IPersonRepository
import ru.zavanton.demo.main.fragments.check.domain.model.PersonCheckDomainModel
import ru.zavanton.demo.main.fragments.check.data.service.IPersonService
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val personService: IPersonService,
    private val storageService: IStorageService,
    private val converter: DataConverter,
) : IPersonRepository {

    override suspend fun fetchPerson(name: String): PersonCheckDomainModel {
        val personCheckDataModel = personService.fetchPersonByName(name)
        val storagePerson = converter.convertToStoragePerson(personCheckDataModel)
        storageService.saveLatestPerson(storagePerson)
        return converter.convertToCheckDomainModel(storagePerson)
    }
}
