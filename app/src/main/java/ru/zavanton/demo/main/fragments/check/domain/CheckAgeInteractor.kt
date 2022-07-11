package ru.zavanton.demo.main.fragments.check.domain

import ru.zavanton.demo.main.fragments.check.domain.model.PersonCheckDomainModel
import javax.inject.Inject

class CheckAgeInteractor @Inject constructor(
    private val personRepository: IPersonRepository,
) : ICheckAgeInteractor {

    override suspend fun checkAgeByName(name: String): PersonCheckDomainModel {
        return personRepository.fetchPerson(name)
    }
}
