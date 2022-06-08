package ru.zavanton.demo.main.fragments.check.data.repository

import ru.zavanton.demo.main.business.IStorageService
import ru.zavanton.demo.main.fragments.check.business.model.PersonModel
import ru.zavanton.demo.main.fragments.check.data.service.ICheckAgeService
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val checkAgeService: ICheckAgeService,
    private val storageService: IStorageService,
) : IPersonRepository {

    override suspend fun fetchPerson(name: String): PersonModel {
        return checkAgeService.checkAge(name)
    }
}
