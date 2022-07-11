package ru.zavanton.demo.main.data

import ru.zavanton.demo.main.data.model.StoragePerson
import ru.zavanton.demo.main.fragments.check.business.model.PersonCheckDomainModel

interface IStorageService {

    suspend fun saveLatestPerson(storagePerson: StoragePerson)

    suspend fun fetchLatestPerson(): StoragePerson

    // TODO remove
    suspend fun saveLatestQuery(personModel: PersonCheckDomainModel)
    suspend fun fetchLatestQuery(): String

}
