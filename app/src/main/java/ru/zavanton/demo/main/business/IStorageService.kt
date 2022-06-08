package ru.zavanton.demo.main.business

import ru.zavanton.demo.main.fragments.check.business.model.PersonModel

interface IStorageService {

    suspend fun saveLatestQuery(personModel: PersonModel)

    suspend fun fetchLatestQuery(): String
}
