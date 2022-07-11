package ru.zavanton.demo.main.fragments.check.data.service

import ru.zavanton.demo.main.fragments.check.business.model.PersonCheckDomainModel

interface IPersonService {

    suspend fun fetchPersonByName(name: String): PersonCheckDomainModel
}
