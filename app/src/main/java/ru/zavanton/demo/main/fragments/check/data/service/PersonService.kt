package ru.zavanton.demo.main.fragments.check.data.service

import ru.zavanton.demo.main.fragments.check.data.api.CheckAgeApi
import ru.zavanton.demo.main.fragments.check.data.model.PersonCheckDataModel
import javax.inject.Inject

class PersonService @Inject constructor(
    private val checkAgeApi: CheckAgeApi,
) : IPersonService {

    override suspend fun fetchPersonByName(name: String): PersonCheckDataModel {
        return checkAgeApi.fetchInfo(name)
    }
}
