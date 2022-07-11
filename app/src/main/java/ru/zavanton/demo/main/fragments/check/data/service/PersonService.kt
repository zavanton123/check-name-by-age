package ru.zavanton.demo.main.fragments.check.data.service

import ru.zavanton.demo.main.fragments.check.business.model.PersonCheckDomainModel
import ru.zavanton.demo.main.fragments.check.data.api.CheckAgeApi
import javax.inject.Inject

class PersonService @Inject constructor(
    private val checkAgeApi: CheckAgeApi,
) : IPersonService {

    override suspend fun fetchPersonByName(name: String): PersonCheckDomainModel {
        return checkAgeApi.fetchInfo(name)
    }
}
