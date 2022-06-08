package ru.zavanton.demo.main.fragments.check.business

interface ICheckAgeInteractor {

    suspend fun checkAgeByName(name: String): Int
}
