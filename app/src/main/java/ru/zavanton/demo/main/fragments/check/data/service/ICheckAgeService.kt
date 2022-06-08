package ru.zavanton.demo.main.fragments.check.data.service

import ru.zavanton.demo.main.fragments.check.business.model.PersonModel

interface ICheckAgeService {

    suspend fun checkAge(name: String): PersonModel
}
