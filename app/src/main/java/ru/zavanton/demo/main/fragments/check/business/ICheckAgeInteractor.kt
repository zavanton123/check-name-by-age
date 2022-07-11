package ru.zavanton.demo.main.fragments.check.business

import ru.zavanton.demo.main.fragments.check.business.model.PersonCheckDomainModel

interface ICheckAgeInteractor {

    suspend fun checkAgeByName(name: String): PersonCheckDomainModel
}
