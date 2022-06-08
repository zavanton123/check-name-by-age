package ru.zavanton.demo.main.fragments.welcome.business

import ru.zavanton.demo.main.business.IStorageService
import javax.inject.Inject

class WelcomeInteractor @Inject constructor(
    private val storageService: IStorageService
) : IWelcomeInteractor {

    override suspend fun fetchLatestName(): String {
        return storageService.fetchLatestQuery()
    }
}
