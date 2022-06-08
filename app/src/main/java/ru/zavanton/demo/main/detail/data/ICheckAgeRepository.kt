package ru.zavanton.demo.main.detail.data

import ru.zavanton.demo.main.detail.business.model.PersonModel

interface ICheckAgeRepository {

    fun saveLatestResult(personDataModel: PersonModel)
}
