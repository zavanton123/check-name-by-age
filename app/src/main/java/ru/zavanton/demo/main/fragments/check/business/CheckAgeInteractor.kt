package ru.zavanton.demo.main.fragments.check.business

import ru.zavanton.demo.main.fragments.check.data.repository.IPersonRepository
import javax.inject.Inject

class CheckAgeInteractor @Inject constructor(
    private val personRepository: IPersonRepository
) : ICheckAgeInteractor {

    override suspend fun checkAgeByName(name: String): Int {
        return personRepository.fetchPerson(name).age
    }
}
