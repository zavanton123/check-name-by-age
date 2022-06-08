package ru.zavanton.demo.main.fragments.welcome.business

interface IWelcomeInteractor {

    suspend fun fetchLatestName(): String
}
