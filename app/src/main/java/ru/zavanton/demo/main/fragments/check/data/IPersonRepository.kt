package ru.zavanton.demo.main.fragments.check.data

import ru.zavanton.demo.main.fragments.check.business.model.PersonModel

interface IPersonRepository {

    fun saveLatestResult(personDataModel: PersonModel)
}
