package ru.zavanton.demo.main.fragments.check.data.repository

import ru.zavanton.demo.EMPTY
import ru.zavanton.demo.main.data.IStorageService
import ru.zavanton.demo.main.data.model.StoragePerson
import ru.zavanton.demo.main.fragments.check.business.IPersonRepository
import ru.zavanton.demo.main.fragments.check.business.model.PersonCheckDomainModel
import ru.zavanton.demo.main.fragments.check.data.model.PersonCheckDataModel
import ru.zavanton.demo.main.fragments.check.data.service.IPersonService
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val personService: IPersonService,
    private val storageService: IStorageService,
) : IPersonRepository {

    override suspend fun fetchPerson(name: String): PersonCheckDomainModel {
        val personCheckDataModel = personService.fetchPersonByName(name)
        val storagePerson = convertToStoragePerson(personCheckDataModel)
        storageService.saveLatestPerson(storagePerson)
        return convertToCheckDomainModel(storagePerson)
    }

    private fun convertToCheckDomainModel(storagePerson: StoragePerson): PersonCheckDomainModel {
        return PersonCheckDomainModel(
            id = storagePerson.id,
            name = storagePerson.name ?: EMPTY,
            age = storagePerson.age ?: 0,
        )
    }

    private fun convertToStoragePerson(personCheckDataModel: PersonCheckDataModel): StoragePerson {
        return StoragePerson(
            id = personCheckDataModel.id,
            name = personCheckDataModel.name,
            age = personCheckDataModel.age,
        )
    }
}
