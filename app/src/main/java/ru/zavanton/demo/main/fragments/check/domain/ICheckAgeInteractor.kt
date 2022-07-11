package ru.zavanton.demo.main.fragments.check.domain

import ru.zavanton.demo.main.fragments.check.domain.model.PersonCheckDomainModel

interface ICheckAgeInteractor {

    suspend fun checkAgeByName(name: String): PersonCheckDomainModel
}
