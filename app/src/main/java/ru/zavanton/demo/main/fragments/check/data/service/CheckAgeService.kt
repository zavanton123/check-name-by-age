package ru.zavanton.demo.main.fragments.check.data.service

import ru.zavanton.demo.main.fragments.check.business.model.PersonModel
import ru.zavanton.demo.main.fragments.check.data.api.CheckAgeApi
import javax.inject.Inject

class CheckAgeService @Inject constructor(
    private val checkAgeApi: CheckAgeApi,
) : ICheckAgeService {

    override suspend fun checkAge(name: String): PersonModel {
        return checkAgeApi.fetchInfo(name)
    }
}
