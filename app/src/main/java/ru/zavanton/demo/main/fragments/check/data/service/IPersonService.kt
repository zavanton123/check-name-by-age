package ru.zavanton.demo.main.fragments.check.data.service

import ru.zavanton.demo.main.fragments.check.data.model.PersonCheckDataModel

interface IPersonService {

    suspend fun fetchPersonByName(name: String): PersonCheckDataModel
}
