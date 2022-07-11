package ru.zavanton.demo.main.fragments.check.data.service

import ru.zavanton.demo.main.fragments.check.business.model.PersonModel
import ru.zavanton.demo.main.fragments.check.data.api.CheckAgeApi
import javax.inject.Inject

class PersonService @Inject constructor(
    private val checkAgeApi: CheckAgeApi,
) : IPersonService {

    override suspend fun fetchPersonByName(name: String): PersonModel {
        return checkAgeApi.fetchInfo(name)
    }
}
